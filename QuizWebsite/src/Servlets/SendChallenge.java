package Servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.User;
import classes.Message.Challenge;
import dao.MessageDAO;
import factory.*;

/**
 * Servlet implementation class SendChallenge
 */
@WebServlet("/SendChallenge")
public class SendChallenge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendChallenge() {
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
		Map<String,String[]> map = request.getParameterMap();
		int quizId = Integer.parseInt(request.getParameter("quizId"));
		User master = (User) request.getSession().getAttribute("MasterUser");
		ClassFactory factory = (ClassFactory) request.getServletContext().getAttribute("factory");
		long date = (new Date()).getTime();
		MessageDAO mD = (MessageDAO) request.getAttribute("messageDAO");
		int i = 0;
		while(true){
			if (map.containsKey(Integer.toString(i))){
				Challenge ch = factory.getChallenge(master.getUserName(), date, map.get(Integer.toString(i))[0], quizId,false);
				mD.addChallenges(ch);
				i++;
			} else break;
		}
		RequestDispatcher rd = request.getRequestDispatcher("Quiz?id=" + quizId);
		rd.forward(request, response);
	}

}
