package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.question.QuestionPR;
import classes.question.Abstract.Question;

/**
 * Servlet implementation class CreatePR
 */
@WebServlet("/CreatePR")
public class CreatePR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePR() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Reads one PRQuestion information and adds it in createdQuestions list in session.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String problem = request.getParameter("statement");
		String pictureURL = request.getParameter("externalURL");
		int grade = Integer.parseInt(request.getParameter("grade"));
		HashSet<String> answers = new HashSet<String>();
		
		String nextAnswer = "";
		
		for(int i = 0; ; i++)
		{
			nextAnswer = request.getParameter("answer" + i);
			if (nextAnswer == null) break;
			answers.add(nextAnswer);
		}
		
		QuestionPR questionPR = new QuestionPR(problem, grade ,pictureURL, answers);
		ArrayList<Question> createdQuestions = (ArrayList<Question>)request.getSession().getAttribute("createdQuestions");
		createdQuestions.add(questionPR);
	}
}
