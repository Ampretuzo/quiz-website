package classes.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import classes.question.Abstract.Question;

public class QuestionMC extends Question {
	
	private Set<String> wrongAnswers;
	private String correctAnswer;
	
	/** 
	 * @param newProblem Description of the problem
	 * @param grade - grade for each correct answer
	 * @param correctAnswer - correct answer
	 * @param wrongAnswers - set of wrong Answers
	 */
	public QuestionMC(String newProblem, int grade, String correctAnswer, Set<String> wrongAnswers)
	{
		super(newProblem, grade, Type.MC);
		setCorrectAnswer(correctAnswer);
		setWrongAnswers(wrongAnswers);
	}

	@Override
	public String toString() {
		String answers = "";
		for (String s : getWrongAnswers()) {
		    answers += s + " ";
		}
		return "Problem: " + this.getProblem() + " | " +
				"Grade: " + getGrade() + " | " +
				"correctAnswer: " + getCorrectAnswer() + " | " +
				"WrongAnswers: " + answers;
	}
	
	@Override
	public List<String> getCorrectAnswers() {
		List<String> answer = new ArrayList<String>();
		answer.add(correctAnswer);
		return answer;
	}

	@Override
	public Integer getGrade(List<String> answer) {
		if(answer == null) throw new IllegalArgumentException("Answer cannot be null!");
		if(!answer.isEmpty() && getCorrectAnswer().equals(answer.get(0)))return getMaxGrade();  
		return 0;
	}
	
	/**
	 * Returns set with all answers.
	 * 
	 * @return allAnswers - set with all answers
	 */
	
	public Set<String> getAllAnswers() {
		Set<String> allAnswers = new HashSet<String>();
		allAnswers.addAll(getWrongAnswers());
		allAnswers.add(getCorrectAnswer());
		return allAnswers;
	}

	/**
	 * Sets a set with wrong answers.
	 * Throws IllegalArgumentException if wrongAnswers is null or contains null.
	 * 
	 * @param wrongAnswers - set with wrong answers
	 */
	private void setWrongAnswers(Set<String> wrongAnswers) {
		if(wrongAnswers == null || wrongAnswers.contains(null)) throw new IllegalArgumentException("WrongAnswers cannot be null!");
		this.wrongAnswers = wrongAnswers;
	}

	/**
	 * Returns a set with wrong answers.
	 * 
	 * @return wrongAnswers - set with wrong answers
	 */
	public Set<String> getWrongAnswers() {
		return wrongAnswers;
	}

	
	@Override
	public int getMaxGrade() {
		return getGrade();
	}

	/**
	 * Returns correctAnswer.
	 * 
	 * @return correctAnswer - string correct answer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * Sets correctAnswer.
	 * Throws IllegalArgumentException if correctAnswer is null.
	 * 
	 * @param correctAnswer - string correct answer
	 */
	public void setCorrectAnswer(String correctAnswer) {
		if(correctAnswer == null) throw new IllegalArgumentException("Correct answer cannot be null!");
		this.correctAnswer = correctAnswer;
	}
}
