package Servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Message.Challenge;
import classes.Message.FriendRequest;
import dao.MessageDAO;
import dao.UserDAO;

/**
 * Servlet implementation class AcceptFriendRequest
 */
@WebServlet("/AcceptFriendRequest")
public class AcceptFriendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptFriendRequest() {
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
		int requestId = Integer.parseInt(request.getParameter("requestId"));
		String status = request.getParameter("status");
		MessageDAO mD = (MessageDAO) request.getServletContext().getAttribute("messageDAO");
		FriendRequest fr = mD.getFriendRequest(requestId);
		fr.setStatus(status);
		mD.addFriendRequest(fr);
		
		UserDAO uD = (UserDAO) request.getServletContext().getAttribute("userDAO");
		classes.User master = (classes.User) request.getSession().getAttribute("MasterUser");
		master = (classes.User) uD.getUser(master.getUserName());
		classes.User getter = (classes.User) uD.getUser(fr.getSenderUserName());
		
		Set<String> friends = master.getFriends(); friends.add(fr.getSenderUserName());
		master.setFriends(friends);
		friends.remove(null);
		
		friends = getter.getFriends(); 
		friends.add(fr.getGetterUserName());
		getter.setFriends(friends);
		friends.remove(null);
		
		uD.updateUser(master);
		uD.updateUser(getter);
	}

}
