package dao;

import java.util.List;

import classes.question.QuestionMC;
import classes.question.QuestionQR;
import classes.question.Abstract.Question;

public interface QuestionDAO {
	
	public void addQR(int quizId, QuestionQR qr);
	
	public void addMC(int quizId, QuestionMC mc);
	
	public List<Question> getQuestions(int quizId);
}
