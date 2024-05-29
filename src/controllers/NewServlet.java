package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Category_tbl;
import models.Message_view;
import utils.DBUtil;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("message", new Message_view());
        //EntityManagerの取得
        EntityManager em = DBUtil.createEntityManager();

        //Message_tblからデータの取得
        List<Category_tbl> categorys = em.createNamedQuery("getCategory", Category_tbl.class).getResultList();
        em.close();

        request.setAttribute("categorys", categorys);

        //指定したjspにとばす
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tool/new.jsp");
        rd.forward(request, response);
//        EntityManager em = DBUtil.createEntityManager();
//        em.getTransaction().begin();
//
//        Message_tbl m = new Message_tbl();
//
//        String title = "名無しさん";
//        m.setTitle(title);
//
//        String content = "こんにちは";
//        m.setContent(content);
//
//        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//        m.setCreated_at(currentTime);
//        m.setUpdated_at(currentTime);
//
//        //record database
//        em.persist(m);
//        em.getTransaction().commit();
//
//        response.getWriter().append(Integer.valueOf(m.getId()).toString());
//        em.close();

    }

}
