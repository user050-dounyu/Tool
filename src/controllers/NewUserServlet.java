package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewUserServlet
 */
@WebServlet("/newUser")
public class NewUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        /*int auth_id = (int) request.getSession().getAttribute("auth_id");
        if(auth_id != 1){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tool/return.jsp");
            rd.forward(request, response);
        }*/

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tool/createUser.jsp");
        rd.forward(request, response);

    }

}
