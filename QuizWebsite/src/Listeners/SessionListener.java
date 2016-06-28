package Listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import classes.Quiz;
import classes.question.QuestionMA;
import classes.question.QuestionMC;
import classes.question.QuestionMCMA;
import classes.question.QuestionPR;
import classes.question.QuestionQR;
import classes.question.Abstract.Question;

//createdQuestions = List with user's created questions.
//MasterUser - user currently logged in.

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    /**
     * Default constructor. 
     */
    public SessionListener() {  }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 

    	ArrayList<Question> questions = new ArrayList<Question>(); // questions stored here while submitting quiz
    	
    	HashSet<String> PRanswers = new HashSet<String>();
    	PRanswers.add("a");
    	PRanswers.add("b");
    	questions.add(new QuestionPR("ProblemPR", 5, "url", PRanswers));
    	
    	HashSet<String> QRanswers = new HashSet<String>();
    	QRanswers.add("c");
    	QRanswers.add("d");
    	questions.add(new QuestionQR("ProblemQR", 5, QRanswers));
    	
    	HashSet<String> wrongAnswers = new HashSet<String>();
    	wrongAnswers.add("b");
    	wrongAnswers.add("c");
    	questions.add(new QuestionMC("ProblemMC", 5, "correct", wrongAnswers));
    	
    	List<Set<String>> answersList = new ArrayList<Set<String>>();
    	answersList.add(new HashSet<>((Arrays.asList("a", "b"))));
    	questions.add(new QuestionMA("ProblemMA", 5, true, answersList, 5));
    	
    	ArrayList<String> correctAnswers = new ArrayList<String>();
    	correctAnswers.add("a");
    	ArrayList<String> incorrectAnswers = new ArrayList<String>();
    	incorrectAnswers.add("b");
    	questions.add(new QuestionMCMA("ProblemMCMA", 5, correctAnswers, incorrectAnswers));
    	
    	Quiz quiz = new Quiz("creatorName", "Quizname", "Very good thank you");
    	quiz.setMaxScore(500);
    	quiz.setOnePage(true);
    	
    	HttpSession s = arg0.getSession();
    	s.setAttribute("Quiz", quiz);  // Used in tests
    	s.setAttribute("Questions", questions);	

    	s.setAttribute("createdQuestions", null);
    	
    	ArrayList<Integer> positions = new ArrayList<Integer>();
    	positions.add(0);
    	positions.add(1);
    	positions.add(2);
    	positions.add(3);
    	positions.add(4);
    	
    	s.setAttribute("questionPositions", positions);  // Order of questions user has to see.
    	s.setAttribute("Result", null); // Result	
    	
    	s.setAttribute("userAnswers", null);
    	s.setAttribute("MasterUser", null);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	HttpSession s = arg0.getSession();
        s.removeAttribute("MasterUser");
        s.removeAttribute("createdQuestions");
    }
}
