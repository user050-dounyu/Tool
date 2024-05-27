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
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/createuser")
public class CreateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            EntityManager em = DBUtil.createEntityManager();
            em.getTransaction().begin();

            int user_id = Integer.parseInt(request.getParameter("user_id"));
            String user_name = request.getParameter("user_name");
            String password = request.getParameter("password");
            String authentication = request.getParameter("authentication");
            int auth_id;

            if(authentication.equals("teatcher")) {
                auth_id = 1;
            }else if(authentication.equals("general")){
                auth_id = 2;
            }else {
                System.out.println(authentication);
                auth_id = 2;
            }
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] hashBytes = md.digest();
            String hash = Base64.getEncoder().encodeToString(hashBytes);

            loginUser lu = new loginUser();
            lu.setUser_id(user_id);
            lu.setUser_name(user_name);
            lu.setPassword(hash);
            lu.setAuth_id(auth_id);

            em.persist(lu);
            em.getTransaction().commit();
            em.close();

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tool/index.jsp");
            rd.forward(request, response);

        }catch(NullPointerException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
