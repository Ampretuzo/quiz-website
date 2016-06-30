package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.User;
import dao.MessageDAO;

/**
 * Servlet implementation class Messages
 */
@WebServlet("/Messages")
public class Messages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Messages() {
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
		User master = (User)request.getSession().getAttribute("MasterUser");
		MessageDAO mD = (MessageDAO) request.getServletContext().getAttribute("messageDAO");
		request.setAttribute("Notes", mD.getNotes(master.getUserName()));
		request.setAttribute("Challenges", mD.getChallenges(master.getUserName()));
		request.setAttribute("FriendRequests", mD.getFriendRequests(master.getUserName()));
		RequestDispatcher rd = request.getRequestDispatcher("Messages.jsp");
		rd.forward(request,response);
	}

}
