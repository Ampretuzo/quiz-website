package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Answer;
import classes.Result;
import classes.User;
import classes.question.Abstract.Question;
import dao.QuizDAO;

/**
 * Servlet implementation class TakeQuiz
 */
@WebServlet("/TakeQuiz")
public class TakeQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakeQuiz() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * This servlet gets called when user starts taking a new quiz.
	 * takenQuizId - quiz id that is taken from the DAO and put in session.
	 * 
	 * Creates a result.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//QuizDAO quizDAO = (QuizDAO)request.getServletContext().getAttribute("quizDAO");
		//classes.Quiz takenQuiz = (classes.Quiz)session.getAttribute("Quiz");	// if taken Quiz != null go to error page. Not thread safe.
		User user = (User)getServletContext().getAttribute("MasterUser"); 	// if(user == null)  goto Error page with null user.
		
		//String takenQuizId = request.getParameter("id");
		//classes.Quiz takenQuiz = (classes.Quiz)quizDAO.getQuiz(Integer.parseInt(takenQuizId));
		//session.setAttribute("Quiz", takenQuiz);
		
		classes.Quiz takenQuiz = (classes.Quiz)session.getAttribute("Quiz");
		
		//Date date = new Date();
		//long startTime = date.getTime();
		//Result result = new Result(user.getUserName(), takenQuiz.getId());
		
		//result.setTimeStarted(startTime);
		//session.setAttribute("Result", result); // Or in session
		
		//questions = quizDAO.getQuizQuestions(quizID);
		//session.setAttribute("Questions", questions);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("QuizMultiplePages.jsp");
		if(takenQuiz.isOnePage()) requestDispatcher = request.getRequestDispatcher("QuizOnePage.jsp");
		requestDispatcher.forward(request, response);	
	}
}