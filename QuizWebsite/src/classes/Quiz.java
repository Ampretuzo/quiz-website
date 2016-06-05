package classes;

import java.util.ArrayList;
import java.util.Set;

public class Quiz {
	public Quiz(String userName, String quizName, String description)
	{
		setUserName(userName);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userName; // Creator
	private int date; // TODO change date format. Creation date.
	private String description; 
	private String quizName;
	private Set<Integer> results; //  Set of results. Each try to fill the quiz is 1 Result. "History"
	private ArrayList<Integer> problems;
	
	// Not necessary, might delete.
	private int maxScore; // Max Score User can get.
	private int quizTime; // Time to take this quiz.
	
	private boolean isRandom;
	private boolean isOnePage;
	private boolean isImmediatelyCorrected;
	private boolean hasPracticeMode;
}
