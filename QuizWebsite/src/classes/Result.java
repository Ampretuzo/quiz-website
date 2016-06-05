package classes;

import java.util.Set;

public class Result {
	public Result(String userName, int quizId)
	{
		setQuizId(quizId);
		setUserName(userName);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	private int quizId;
	private String userName;
	private Integer finalGrade = null;
	private int timeStarted; // change format
	private int timeFinished;
	private int timeTaken;
	private Set<Integer> answers; // Set of integers user got.
}
