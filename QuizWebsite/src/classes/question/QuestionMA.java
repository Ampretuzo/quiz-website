package classes.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import classes.question.Abstract.Question;

public class QuestionMA extends Question {

	private List<Set<String>> answers;
	private boolean ordered;
	private int numAnswers;
	
	/** 
	 * @param newProblem - Description of the problem with special characters for blanks
	 * @param grade - grade for each correct answer
	 * @param ordered - true if answers must be ordered, false otherwise
	 * @param answers - List of Sets of Strings with correct answers for each blank. Must not be empty
	 */
	public QuestionMA(String newProblem, int grade, boolean ordered, List<Set<String>> answers, int numAnswers) {
		super(newProblem, grade, Type.MA);
		setNumAnswers(numAnswers); 
		setOrdered(ordered);
		setAnswers(answers);
	}
	
	@Override
	public String toString() {
		String answers = "";
		List<Set<String>> setAnswers = getAnswers();
		Iterator<String> iterator;
		for (int i = 0; i < setAnswers.size(); i++)
		{
			iterator = setAnswers.get(i).iterator();
			answers += i + ") ";
			while(iterator.hasNext()) answers += iterator.next() + " ";
		}
		return "Problem: " + this.getProblem() + " | " +
				"Grade: " + getGrade() + " | " +
				"Ordered: " + isOrdered() + " | " +
				"Answers: " + answers +
				"NumAnswers: " + getNumAnswers();
	}

	@Override
	public ArrayList<String> getCorrectAnswers() {
		ArrayList<String> correctAnswers = new ArrayList<String>();
		Iterator<Set<String>> answersIterator = getAnswers().iterator();
		
		while(answersIterator.hasNext())
			correctAnswers.add(answersIterator.next().iterator().next()); // Take one element from each set.
		return correctAnswers;
	}

	@Override
	public Integer getGrade(List<String> answer) {
		if(answer == null || answer.size() != numAnswers || answer.contains(null))
			throw new IllegalArgumentException("Wrong passed answer argument length");
		Integer grade = 0;
		Iterator<String> answerIterator = answer.iterator();
		Iterator<Set<String>> correctAnswersIterator;
		if(ordered)
		{	
			correctAnswersIterator = getAnswers().iterator();
			while(answerIterator.hasNext() && correctAnswersIterator.hasNext())
				if(correctAnswersIterator.next().contains(answerIterator.next())) grade += getGrade();
		}
		else
		{
			HashSet<String> previousCorrectAnswers = new HashSet<String>();
			String nextAnswer;
			Set<String> nextSet;
			while(answerIterator.hasNext())
			{
				nextAnswer = answerIterator.next();
				correctAnswersIterator = getAnswers().iterator();
				while(correctAnswersIterator.hasNext())
				{
					nextSet = correctAnswersIterator.next();
					if(nextSet.contains(nextAnswer) && Collections.disjoint(nextSet, previousCorrectAnswers))
					{
						grade += getGrade();
						previousCorrectAnswers.add(nextAnswer);
					}
				}
			}
		}
		return grade;
	}

	/**
	 * Returns max grade user can get in this question.
	 * 
	 * @return maxGrade - maximum grade user can get in this question
	 */
	@Override
	public int getMaxGrade() {
		return getGrade()*getAnswers().size();
	}
	
	/**
	 * Returns List of Sets of question answers.
	 *  
	 * @return answers - List of Sets of question answers
	 */
	public List<Set<String>> getAnswers() {
		return answers;
	}

	/**
	 * Sets List of Sets of question answers. 
	 * Throws IllegalArgumentException if answers contains null or is empty.
	 *  
	 * @param answers - List of Sets of question answers
	 */
	
	public void setAnswers(List<Set<String>> answers) {
		if(answers == null || answers.isEmpty()) throw new IllegalArgumentException("Answer cannot be null or empty!");
		for(int i = 0; i < answers.size(); i++)
			if(answers.get(i) == null || answers.get(i).isEmpty() || answers.get(i).contains(null)) 
				throw new IllegalArgumentException("Wrong inner set format!");
		this.answers = answers;
	}

	/**
	 * Returns true if answers are ordered.  
	 * 
	 * @return ordered - true if answers are ordered.
	 */
	public boolean isOrdered() {
		return ordered;
	}

	/**
	 * Sets the question to be ordered.  
	 * 
	 * @param ordered - true if answers are ordered.
	 */
	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public int getNumAnswers() {
		return numAnswers;
	}

	public void setNumAnswers(int numAnswers) {
		this.numAnswers = numAnswers;
	}
}
