package classes;

import java.util.List;

public class Result {
	
	private int quizId;
	private String userName;
	private int finalGrade = -1;
	private long timeStarted; 
	private long timeTaken;
	private List<Answer> answers;
	
	@Override
	public String toString() {
		return "quiz: " + quizId + ", user: " + userName + ", quiz grade: " + 
				finalGrade + ", started: " + timeStarted + ", elapsed: " + 
				timeTaken + " ms, answers: " + answers.toString();
	}
	
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

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
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
