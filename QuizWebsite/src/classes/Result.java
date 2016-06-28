package classes;

import java.util.List;

public class Result {
	
	private int quizId;
	private String userName;
	private Integer finalGrade = null;
	private long timeStarted; 
	private long timeTaken;
	private List<Answer> answers;
	
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

	public Integer getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(Integer finalGrade) {
		this.finalGrade = finalGrade;
	}

	public long getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(long timeStarted) {
		this.timeStarted = timeStarted;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}

	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
