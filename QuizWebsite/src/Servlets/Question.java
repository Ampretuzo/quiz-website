package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Question
 */
@WebServlet("/Question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Question() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int id = (Integer.parseInt(request.getParameter("id")));
    	ArrayList<classes.question.Abstract.Question> questions = (ArrayList<classes.question.Abstract.Question>)request.getSession().getAttribute("Questions");
    	String type = questions.get(id).getType();

    	RequestDispatcher rd = request.getRequestDispatcher("Test/" + type + ".jsp?id=" + id);
    	rd.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (Integer.parseInt(request.getParameter("id")));
		ArrayList<classes.question.Abstract.Question> questions = (ArrayList<classes.question.Abstract.Question>)request.getSession().getAttribute("Questions");
		String type = questions.get(id).getType();
		
		RequestDispatcher rd = request.getRequestDispatcher("Test/" + type + ".jsp?id=" + id);
		rd.forward(request, response);	
	}
}
