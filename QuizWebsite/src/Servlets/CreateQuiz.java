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

import classes.User;
import classes.question.Abstract.Question;
import dao.QuizDAO;
import factory.ClassFactory;

/**
 * Servlet implementation class CreateQuiz
 */
@WebServlet("/CreateQuiz")
public class CreateQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateQuiz() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		long creationMillis = date.getTime();
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		boolean random = (request.getParameter("random") == null);
		boolean onepage = (request.getParameter("onepage") == null);
		boolean practice = (request.getParameter("practice") == null);
		boolean correction = (request.getParameter("correction") == null);
		int numMinutes = Integer.parseInt(request.getParameter("time"));
		
		HttpSession session = request.getSession();
		User masterUser = (User)session.getAttribute("MasterUser");
		ArrayList<Question> questions = (ArrayList<Question>)session.getAttribute("QuestionList");
		
		ClassFactory factory = (ClassFactory)request.getServletContext().getAttribute("factory");
		classes.Quiz newQuiz = factory.getQuiz(masterUser.getUserName(), name, description);
		newQuiz.setDateCreated(creationMillis);
		newQuiz.setHasPracticeMode(practice);
		newQuiz.setImmediatelyCorrected(correction);
		newQuiz.setOnePage(onepage);
		newQuiz.setRandom(random);
		newQuiz.setQuizTime(numMinutes);
		
		QuizDAO quizDAO = (QuizDAO)request.getServletContext().getAttribute("quizDAO");
		int id = quizDAO.addQuiz(newQuiz);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Quiz?id=" + id);
		requestDispatcher.forward(request, response);	
	}
}
