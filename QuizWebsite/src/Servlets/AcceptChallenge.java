package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Result;
import classes.Message.Challenge;
import dao.MessageDAO;
import dao.ResultDAO;

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
		if (request.getSession().getAttribute("MasterUser") == null) return;
		int challengeId = Integer.parseInt(request.getParameter("challengeId"));
		MessageDAO mD = (MessageDAO) request.getServletContext().getAttribute("messageDAO");
		String status = request.getParameter("status");
		Challenge ch = mD.getChallenge(challengeId);
		ch.setStatus(status); 
		mD.updateChallengeStatus(ch.getId(), status);
		
		
		if (status.equals("Accept")) {
			request.getSession().setAttribute("Challenger", ch.getSenderUserName());
			ResultDAO rD = (ResultDAO) request.getServletContext().getAttribute("resultDAO");
			List<Result> res = rD.getResult(ch.getGetterUserName(), ch.getQuizId());
			int maxx = 0;
			for (int i=0;i<res.size();i++){
				if (res.get(i).getFinalGrade() > maxx) maxx = res.get(i).getFinalGrade();
			}
			request.getSession().setAttribute("ChallengerScore", maxx);
			response.sendRedirect("Quiz?id=" + ch.getQuizId());
		} else 	response.sendRedirect("Message");
	}

}
