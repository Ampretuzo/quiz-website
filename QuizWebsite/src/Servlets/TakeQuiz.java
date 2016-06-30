package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
import dao.QuestionDAO;
import dao.QuizDAO;
import classes.question.Abstract.Question;

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
	 * sets:
	 * 1 Quiz - quiz being taken
	 * 2 Result - Result
	 * 3 Questions - current questions
	 * 4 List<Integer> questionPositions - order of questions
	 * 
	 * Creates a result.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		classes.Quiz takenQuiz = setQuiz(session, request);
		setResult(session, takenQuiz.getId());
		setQuestions(session, request, takenQuiz.getId()); // Not working.
		setNumPositions(session, takenQuiz.isRandom());
<<<<<<< HEAD
=======
		setQuestions(session, request, takenQuiz.getId()); // Not working.
>>>>>>> refs/remotes/Ampretuzo/master
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("QuizMultiplePages.jsp");
		if(takenQuiz.isOnePage()) requestDispatcher = request.getRequestDispatcher("QuizOnePage.jsp");
		requestDispatcher.forward(request, response);	
	}
	
	private classes.Quiz setQuiz(HttpSession session, HttpServletRequest request)
	{
		QuizDAO quizDAO = (QuizDAO)request.getServletContext().getAttribute("quizDAO");
		int id = Integer.parseInt(request.getParameter("id"));
		classes.Quiz takenQuiz = (classes.Quiz)quizDAO.getQuiz(id);
		session.setAttribute("Quiz", takenQuiz); 
		return takenQuiz;
	}
	
	private void setQuestions(HttpSession session, HttpServletRequest request, int takenQuizId)
	{
		QuestionDAO questionDAO = (QuestionDAO)request.getServletContext().getAttribute("questionDAO");
		List<Question> questions = questionDAO.getQuestions(takenQuizId);
<<<<<<< HEAD
		session.setAttribute("Questions", questions);System.out.println(questions.size());
=======
		session.setAttribute("Questions", questions);
>>>>>>> refs/remotes/Ampretuzo/master
	}
	
	private void setNumPositions(HttpSession session, boolean randomize)
	{
		ArrayList<Integer> questionPositions = new ArrayList<Integer>();
		List<Question> questions = (List<Question>) session.getAttribute("Questions");
		for(int i = 0; i <questions.size(); i++) questionPositions.add(i);
		if(randomize) Collections.shuffle(questionPositions);
		session.setAttribute("questionPositions", questionPositions); System.out.println(questionPositions.size());
	}
	
	private void setResult(HttpSession session, int takenQuizId)
	{
<<<<<<< HEAD
		User user = (User)session.getAttribute("MasterUser"); 	
=======
		User user = (User)getServletContext().getAttribute("MasterUser"); 	
>>>>>>> refs/remotes/Ampretuzo/master
		Result result = new Result(user.getUserName(), takenQuizId);
		
		List<Answer> answers = new ArrayList<Answer>();
		result.setAnswers(answers);
		Date date = new Date();
		long startTime = date.getTime();
		result.setTimeStarted(startTime);
		session.setAttribute("Result", result); 
	}
}