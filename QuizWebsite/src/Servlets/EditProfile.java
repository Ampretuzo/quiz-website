package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.PasswordHasher;
import classes.User;
import dao.UserDAO;

/**
 * Servlet implementation class EditImage
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
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
		User master = (User) request.getSession().getAttribute("MasterUser");
		master.setImage(request.getParameter("imageURL"));
		master.setDescription(request.getParameter("description"));
		if (request.getParameter("changepassword") != null) {
			PasswordHasher hasher = (PasswordHasher)request.getServletContext().getAttribute("hasher");
			String salt = hasher.getRandomSalt();
			master.setSalt(salt);
			master.setHashedPassword(hasher.hashPassword(request.getParameter("newpass") + salt));
		}
		String username = master.getUserName();
		UserDAO uD = (UserDAO) request.getServletContext().getAttribute("userDAO");
		uD.updateUser(master);
		request.getSession().setAttribute("MasterUser", uD.getUser(username));
		
		response.sendRedirect("Profile?username=" + username);
	}

}
