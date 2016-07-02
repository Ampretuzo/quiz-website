package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.Constants;
import dao.MessageDAO;
import dao.QuizDAO;
import dao.ResultDAO;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageDAO mD = (MessageDAO) request.getServletContext().getAttribute("messageDAO");
		QuizDAO qD = (QuizDAO) request.getServletContext().getAttribute("quizDAO");
		ResultDAO rD = (ResultDAO) request.getServletContext().getAttribute("resultDAO");
		request.setAttribute("Announcements", mD.getAnnouncements());
		
		String param = request.getParameter("popular");
		long fromTimeInMs = -1;
		if (param == null) fromTimeInMs = System.currentTimeMillis() - Constants.ALLTIME_IN_MS; else {
			if (param.equals("week")) fromTimeInMs = System.currentTimeMillis() - Constants.WEEK_IN_MS; else {
				if (param.equals("day")) fromTimeInMs = System.currentTimeMillis() - Constants.DAY_IN_MS;
			}
		}
		request.setAttribute("PopularQuizzes", rD.getPopularQuizzes(Constants.MAX_DISPLAY, fromTimeInMs));
		//request.setAttribute("RecentQuizzes", qD.getRecentQuizzes(Constants.MAX_DISPLAY));
		request.setAttribute("RecentQuizzes", new ArrayList<Quiz>());
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
