package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Answer;
import classes.Result;
import classes.question.Abstract.Question;

/**
 * Servlet implementation class SubmitQR
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Gets called for each question. Creates an Answer.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		List<String> userAnswer = new ArrayList<String>();
		int numAnswers = (request.getParameterMap().keySet().size()-1);
		int position = Integer.parseInt(request.getParameter("questionPosition"));
		
		String nextAnswer = ""; 
		for(int i = 0; ; i++)
		{
			if (0 == numAnswers) break;
			nextAnswer = request.getParameter("answer" + i);
			if (nextAnswer == null) continue;
			userAnswer.add(nextAnswer);
			numAnswers--;
		}
		
		Answer answer = new Answer(userAnswer);
		
		ArrayList<Question> questions = (ArrayList<Question>)session.getAttribute("Questions");
		int grade = questions.get(position).getGrade(userAnswer);
		answer.setGrade(grade);

		Result result = (Result)session.getAttribute("Result");
		System.out.println(questions.size());
		result.getAnswers().set(position, answer);
		System.out.println(answer.toString());

		classes.Quiz quiz = (classes.Quiz) (request.getSession().getAttribute("Quiz"));
		if (quiz.isImmediatelyCorrected()) {
			out.print("questionResult.jsp?id=" + position + "&grade=" + grade + "&maxGrade=" + questions.get(position).getMaxGrade());
		} else out.print("");
	}
}
