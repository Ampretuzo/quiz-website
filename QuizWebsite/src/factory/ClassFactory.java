package factory;
import java.util.List;
import java.util.Set;

import classes.Quiz;
import classes.User;
import classes.question.QuestionFB;
import classes.question.QuestionMA;
import classes.question.QuestionMC;
import classes.question.QuestionMCMA;
import classes.question.QuestionPR;
import classes.question.QuestionQR;
import classes.question.QuestionTF;

public class ClassFactory {
	// Each method returns corresponding class.
	
	public User getUser(String userName, String password, String salt)
	{
		return new User(userName, password, salt);
	}
	
	public Quiz getQuiz(String userName, String quizName, String description)
	{
		return new Quiz(userName, quizName, description);
	}
	
	public QuestionQR getQuestionQR(String newProblem, int grade, Set<String> newAnswers)
	{
		return new QuestionQR(newProblem, grade, newAnswers);
	}
	
	public QuestionPR getQuestionPR(String newProblem, int grade, String pictureURL, Set<String> newAnswers)
	{
		return new QuestionPR(newProblem, grade, pictureURL, newAnswers);
	}
	
	public QuestionFB getQuestionFB(String newProblem, int grade, List<Set<String>> newAnswers)
	{
		return new QuestionFB(newProblem, grade, newAnswers);
	}
	
	public QuestionMA getQuestionMA(String newProblem, int grade, boolean graded, List<Set<String>> newAnswers, int numAnswers)
	{
		return new QuestionMA(newProblem, grade, graded, newAnswers, numAnswers);
	}
	
	public QuestionMC getQuestionMC(String newProblem, int grade, String correctAnswer, Set<String> wrongAnswers)
	{
		return new QuestionMC(newProblem, grade, correctAnswer, wrongAnswers);
	}
	
	public QuestionMCMA getQuestionMCMA(String newProblem, int grade,  List<String> correctAnswers, List<String> wrongAnswers)
	{
		return new QuestionMCMA(newProblem, grade, correctAnswers, wrongAnswers);
	}
	
	public QuestionTF getQuestionTF(String newProblem, int grade,  List<String> propositions, List<String> answers)
	{
		return new QuestionTF(newProblem, grade, propositions, answers);
	}
}
