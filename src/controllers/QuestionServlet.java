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

import models.Message_view;
import utils.DBUtil;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //EntityManagerの取得
        EntityManager em = DBUtil.createEntityManager();

        //Message_tblからデータの取得
        List<Message_view> messages = em.createNamedQuery("getQuestionMessages", Message_view.class).getResultList();
        em.close();

        request.setAttribute("messages", messages);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tool/question.jsp");
        rd.forward(request, response);
    }

}
