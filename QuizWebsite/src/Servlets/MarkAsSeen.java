package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.User;
import dao.MessageDAO;

/**
 * Servlet implementation class MarkAsSeen
 */
@WebServlet("/MarkAsSeen")
public class MarkAsSeen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkAsSeen() {
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
		if (master == null) return;
		int messageId = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		MessageDAO mD = (MessageDAO) request.getServletContext().getAttribute("messageDAO");
		
		
		
		if (type.equals("Challenge")) {
			mD.seenChallenge(messageId);
		} else if (type.equals("Note")) {
			System.out.println(type);
			if (!master.getUserName().equals(mD.getNote(messageId).getSenderUserName())) {mD.seenNote(messageId);System.out.println("yle");}
		} else {
			mD.seenFriendRequest(messageId);
		}
		
	}

}
