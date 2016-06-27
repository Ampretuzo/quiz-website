package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.PasswordHasher;
import classes.User;
import dao.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *  Checks if such user exists and password is correct, then sets session's MasterUser to user.
	 *  and goes to index.jsp.
	 *  else redirects to invalidlogin.jsp.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password"); 
		
		RequestDispatcher dispatcher;
		ServletContext ctx= getServletContext();  
		UserDAO userDAO = (UserDAO)ctx.getAttribute("userDAO");
		PasswordHasher hasher = (PasswordHasher)ctx.getAttribute("hasher");
		User user = userDAO.getUser(userName);
		
		dispatcher = request.getRequestDispatcher("invalidlogin.jsp");	
		
		if(user != null && hasher.hashPassword(password + user.getSalt()).equals(user.getHashedPassword()))
		{
			request.getSession().setAttribute("MasterUser", user);
			dispatcher = request.getRequestDispatcher("index.jsp");
		}		
		dispatcher.forward(request, response);
	}
}
