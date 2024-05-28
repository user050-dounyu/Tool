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
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        Message_tbl m = new Message_tbl();

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        m.setTitle(title);
        m.setContent(content);
        m.setCreated_at(currentTime);
        m.setUpdated_at(currentTime);

        //エンティティの新規追加（引数にエンティティクラスのインスタンスを指定）
        em.persist(m);
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath() + "/index");
    }

}
