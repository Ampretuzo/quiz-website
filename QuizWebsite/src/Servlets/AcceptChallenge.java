package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Message.Challenge;
import dao.MessageDAO;

/**
 * Servlet implementation class AcceptChallenge
 */
@WebServlet("/AcceptChallenge")
public class AcceptChallenge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptChallenge() {
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
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (request.getSession().getAttribute("MasterUser") == null) return;
		int challengeId = Integer.parseInt(request.getParameter("challengeId"));
		MessageDAO mD = (MessageDAO) request.getServletContext().getAttribute("messageDAO");
		String status = request.getParameter("status");
		Challenge ch = mD.getChallenge(challengeId);
		ch.setStatus(status); 
		mD.addChallenges(ch);
		
		if (status.equals("Accept")) out.print("Quiz?id=" + ch.getQuizId()); else out.print("Decline");
	}

}
