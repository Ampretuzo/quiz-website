package problem.Abstract;

public abstract class Answer {
	private int grade;
	private boolean graded = false;
	private int problemId;
	private Object userAnswer;


	/**
	 *  Constructor stores test's id number and user's answer object.
	 */
	public Answer(int newTestId, Object newUserAnswer) 
	{
		problemId = newTestId;
		userAnswer = newUserAnswer;
	}

	/**
	 * Returns an object with all information about Answer.
	 * @return answer.
	 */
	public Object getAnswer()
	{	
		return userAnswer;
	}

	/**
	 * Sets the grade user in object.
	 */
	public void setGrade(int newGrade)
	{
		grade = newGrade;
		graded = true;
	}

	/**
	 * Returns id of the test.
	 * @return id of test.
	 */
	public int getTestId()
	{
		return problemId;
	}

	/**
	 * Returns grade of user or null if answer was not graded yet.
	 * @return grade or null.
	 */
	public Integer getGrade()
	{
		if(graded) return grade;
		return null;
	}

	/**
	 * Returns true if answer was graded.
	 * @return graded.
	 */
	public boolean isGraded()
	{
		return graded;
	}
}
