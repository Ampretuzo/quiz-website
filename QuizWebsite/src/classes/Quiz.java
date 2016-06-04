package classes;

import java.util.Set;

public class Quiz {
	private String userName; // Creator
	private int date; // TODO change dade format. Creation date.
	private String description; 
	private String name;
	private Set<Integer> results; //  Set of results. Each try to fill the quiz is 1 Result.
	
	// Not necessary, might delete.
	private int maxScore; // Max Score User can get.
	private int quizTime; // Time to take this quiz.
	
	private boolean isRandom;
	private boolean isOnePage;
	private boolean isImmediatelyCorrected;
	private boolean hasPracticeMode;
}
