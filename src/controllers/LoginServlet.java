package controllers;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.loginUser;
import utils.DBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{

              EntityManager em = DBUtil.createEntityManager();

                loginUser lu = em.find(loginUser.class, Integer.parseInt(request.getParameter("user_id")));

                em.close();

                String user_id = request.getParameter("user_id");
                String password = request.getParameter("password");
                MessageDigest md = MessageDigest.getInstance("SHA-256");

                md.update(password.getBytes());
                byte[] hashBytes = md.digest();
                String hash = Base64.getEncoder().encodeToString(hashBytes);

                if(lu.getPassword().equals(hash)) {
                    request.getSession().setAttribute("user_id", lu.getUser_id());
                    request.getSession().setAttribute("user_name", lu.getUser_name());
                    request.getSession().setAttribute("auth_id", lu.getAuth_id());
                    request.setAttribute("_token", request.getSession().getId());

                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tool/main.jsp");
                    rd.forward(request, response);
                }else {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tool/err.jsp");
                    rd.forward(request, response);
                }

        }catch(NullPointerException e){

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tool/err.jsp");
            rd.forward(request, response);
            e.printStackTrace();
        }catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
