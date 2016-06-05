package classes.problem.Abstract;

import java.util.ArrayList;

public abstract class Problem{

	/**
	 * Returns ArrayList's grade, or null if wrong format.	
	 * @param answer ArrayList of user's filled fields.
	 * @return grade of answer.
	*/
	public abstract Integer getGrade(ArrayList<String> answer);
	
	/**
	 * This function returns statement for user to see.
	 * @return Statement.
	*/
	public abstract Statement getStatement();	
	
	/**
	 * This function returns length of user's expected Array of answers.
	 * @return answer length.
	*/
	public abstract Integer getAnswerLength();
	
	/**
	 * This function returns array of right answers to show user.
	 * @return ArrayList of right answers.
	*/
	public abstract ArrayList<String> getRightAnswers();
}
