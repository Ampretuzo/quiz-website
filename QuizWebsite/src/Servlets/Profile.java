package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Main.Constants;
import classes.Result;
import classes.User;
import dao.QuizDAO;
import dao.ResultDAO;
import dao.UserDAO;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		System.out.println(userName);
		RequestDispatcher dispatcher;
		ServletContext ctx= getServletContext();  
		UserDAO userDAO = (UserDAO)ctx.getAttribute("userDAO");
		dispatcher = request.getRequestDispatcher("notfound.jsp");	
		
		QuizDAO quizDao= (QuizDAO)ctx.getAttribute("quizDAO");
		ResultDAO resultDao= (ResultDAO)ctx.getAttribute("resultDAO");
		
		request.setAttribute("createdQuizzes", quizDao.getCreatedQuizzes(userName));
		
		List<Result> recent = resultDao.getRecentResults(userName, Constants.MAX_DISPLAY);
		request.setAttribute("recentResults", recent);
		List<classes.Quiz> recQuiz= new ArrayList<classes.Quiz>();
		if (recent!= null){
		for (Result res : recent){
			recQuiz.add(quizDao.getQuiz(res.getQuizId()));
		}}
		request.setAttribute("recentQuizzes", recQuiz);
		
		User user = userDAO.getUser(userName);
		if(user != null)
		{
			request.setAttribute("User", user);
			dispatcher = request.getRequestDispatcher("Profile.jsp?username=" + userName);
		}
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Takes user Id as parameter and goes to Profile.jsp if found and 
	 * 
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
