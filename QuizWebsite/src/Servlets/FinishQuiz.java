package Servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Answer;
import classes.Result;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * This servlet gets called at the end of each quiz.
	 * Takes finish time.
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Date date = new Date();
		Result result = (Result)session.getAttribute("Result");
		result.setTimeTaken(result.getTimeStarted() - date.getTime());
		
		int finalGrade = 0;
		List<Answer> answers = result.getAnswers();
		for(Answer ans : answers) finalGrade += ans.getGrade();
		result.setFinalGrade(finalGrade);
			
		// if not practice mode send to database.						
				
				
				
				
	}
}
