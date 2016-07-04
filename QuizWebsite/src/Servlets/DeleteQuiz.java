package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuizDAO;
import dao.ResultDAO;

/**
 * Servlet implementation class DeleteQuiz
 */
@WebServlet("/DeleteQuiz")
public class DeleteQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuiz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int quizId = Integer.parseInt(request.getParameter("quizId"));
		QuizDAO quizDao= (QuizDAO)request.getServletContext().getAttribute("quizDAO");
		quizDao.deleteQuiz(quizId);
		ResultDAO resultDAO = (ResultDAO)request.getServletContext().getAttribute("resultDAO");
		resultDAO.removeHistory(quizId);
		RequestDispatcher rd = request.getRequestDispatcher("index");
		rd.forward(request, response);		
	}

}
