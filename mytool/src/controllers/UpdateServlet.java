package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message_tbl;
import utils.DBUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();

        Message_tbl m = em.find(Message_tbl.class, (Integer)request.getSession().getAttribute("message_id"));

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        m.setTitle(title);
        m.setContent(content);
        m.setUpdated_at(currentTime);

        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();

        request.getSession().removeAttribute("message_id");

        //リダイレクト
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
