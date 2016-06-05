package classes.problem.QR;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import classes.problem.Abstract.Problem;

public class ProblemQR extends Problem{

	private static final int QR_ANSWER_LENGTH = 1;
	
	private StatementQR problem;
	private Set<String> answers;
	
	public ProblemQR(String newDescription, Set<String> newAnswers)
	{
		problem = new StatementQR(newDescription);
		answers = newAnswers;
	}
	
	
	@Override
	public Integer getGrade(ArrayList<String> answer)
	{
		if(answer.size() != getAnswerLength()) return null;
		String userAnswer = answer.get(0);   
		if(getAnswers().contains(userAnswer)) return 1;
		return 0;
	}

	public Set<String> getAnswers()
	{
		return answers;
	}
	
	@Override
	public StatementQR getStatement() 
	{
		return problem;
	}

	@Override
	public Integer getAnswerLength() 
	{
		return QR_ANSWER_LENGTH;
	}


	@Override
	public ArrayList<String> getRightAnswers() {
		Iterator<String> answerIterator = answers.iterator();
		return  new ArrayList<String>(){{  add(answerIterator.next()); }};
	}
}

