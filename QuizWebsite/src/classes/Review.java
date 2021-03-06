package classes;

/**
 * Immutable
 * 
 * @author sergi
 *
 */
public class Review {

	private String text;
	private long date;
	private String userName;
	private int quizId;
	private int rating;
	
	@Override
	public String toString() {
		return "quiz: " + quizId + ", username: " + userName + ", text: " + text + ", rating: " + rating + "|||";
	}
	
	public Review(String text, long date, String userName, int quizId, int rating) {
		this.text = text;
		this.date = date;
		this.userName = userName;
		this.quizId = quizId;
		this.rating = rating;
	}
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * @return the date
	 */
	public long getDate() {
		return date;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @return the quizId
	 */
	public int getQuizId() {
		return quizId;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

}
