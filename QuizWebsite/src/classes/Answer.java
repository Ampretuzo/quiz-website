package classes;

import java.util.List;

public class Answer {
	private Integer grade = null; // Null if not graded.
	private List<String> userAnswer;

	/**
	 *  Constructor stores problem's id number and user's answer object.
	 */
	public Answer(List<String> userAnswer) 
	{
		this.userAnswer = userAnswer;
	}

	@Override
	public String toString() {
		String answer = "";
		for(int i = 0; i < getAnswer().size(); i ++)
			answer += "Answer " + i + ": " + getAnswer().get(i) + " | ";
		return "Answers: " + answer + ", Grade: " + getGrade();
	}
	
	/**
	 * Returns a list with all information about Answer.
	 * @return answer.
	 */
	public List<String> getAnswer()
	{	
		return userAnswer;
	}	

	/**
	 * Sets the grade user in object.
	 */
	public void setGrade(Integer newGrade)
	{
		grade = newGrade;
	}

	/**
	 * Returns grade of user or null if answer was not graded yet.
	 * @return grade or null.
	 */
	public Integer getGrade()
	{
		return grade;
	}
}
