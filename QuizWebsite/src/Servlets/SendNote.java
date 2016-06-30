package Servlets;

import java.io.IOException;
import java.util.Date;

import classes.*;
import classes.Message.*;
import dao.MessageDAO;
import factory.ClassFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendNote
 */
@WebServlet("/SendNote")
public class SendNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendNote() {
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
		String getterUsername = request.getParameter("getter");
		String note = request.getParameter("note");
		User master = (User) request.getSession().getAttribute("MasterUser");
		ClassFactory factory = (ClassFactory) request.getServletContext().getAttribute("factory");
		long date = (new Date()).getTime();
		Note nt = factory.getNote(master.getUserName(), date, note, getterUsername, false);
		MessageDAO mD = (MessageDAO) request.getServletContext().getAttribute("messageDAO");
		mD.addNote(nt);
		RequestDispatcher rd = request.getRequestDispatcher("Profile?username=" + getterUsername);
		rd.forward(request, response);
	}

}
