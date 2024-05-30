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
        int user_id = (int) request.getSession().getAttribute("user_id");
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        int status_id = 3;
        /*if(request.getParameter("status").equals("question")) {
            status_id = 1;
        }else if(request.getParameter("status").equals("finish")){
            status_id = 2;
        }else {
            status_id = 3;

        }*/
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        m.setTitle(title);
        m.setMessageContents(content);
        m.setUserId(user_id);
        m.setCategoryId(category_id);
        m.setMessageTime(currentTime);
        if(status_id != 0) {
            m.setStatusId(status_id);
        }
        //エンティティの新規追加（引数にエンティティクラスのインスタンスを指定）
        em.persist(m);
        em.getTransaction().commit();
        em.close();

        response.sendRedirect(request.getContextPath() + "/main");
    }

}
