package problem.QR;

import java.util.Set;

import problem.Abstract.Problem;

public class ProblemQR extends Problem<AnswerQR>{

	public ProblemQR(String newDescription, Set<String> newAnswers)
	{
		problem = new StatementQR(newDescription);
		answers = newAnswers;
	}
	
	private StatementQR problem;
	private Set<String> answers;
	
	@Override
	public void setGrade(AnswerQR answer) 
	{
		String userAnswer = (String)answer.getAnswer();
		if(answers.contains(userAnswer)) answer.setGrade(1);
		else answer.setGrade(0);
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
}

