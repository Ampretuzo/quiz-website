package Servlets;

import java.io.IOException;
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
import classes.Quiz;

/**
 * Servlet implementation class FinishQuiz
 */
@WebServlet("/FinishQuiz")
public class FinishQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinishQuiz() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();

    	Quiz takenQuiz = (Quiz)session.getAttribute("Quiz");
    	Date date = new Date();
    	Result result = (Result)session.getAttribute("Result");
    	result.setTimeTaken(result.getTimeStarted() - date.getTime());

    	int finalGrade = 0;
    	List<Answer> answers = result.getAnswers();
    	for(Answer ans : answers) finalGrade += ans.getGrade();
    	result.setFinalGrade(finalGrade);
    	
    	int oldNumTries = takenQuiz.getNumTries();
    	
    	takenQuiz.setNumTries(oldNumTries + 1);
    	takenQuiz.setAverageScore( 		 ( takenQuiz.getAverageScore()*oldNumTries+result.getFinalGrade() ) /   (oldNumTries + 1) );
    	takenQuiz.setAverageTimeMillis(  ( takenQuiz.getAverageTimeMillis()*oldNumTries+result.getTimeTaken() ) /   (oldNumTries + 1) );
    	
    	request.setAttribute("Result", result);
		request.setAttribute("Quiz", takenQuiz); 
    	// if not practice mode send to database.
		
		session.setAttribute("questionPositions", null);
		session.setAttribute("Result", null); 
		session.setAttribute("Questions", null); 
		session.setAttribute("Quiz", null);

    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("quizResult.jsp");
    	requestDispatcher.forward(request, response);	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * 
     * This servlet gets called at the end of each quiz.
     * Takes finish time.
     * 
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}