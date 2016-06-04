package classes;

import java.util.Set;

public class Result {
	int quizId;
	String userName;
	int finalGrade;
	int timeStarted; // change format
	int timeFinished;
	int timeTaken;
	boolean graded;
	Set<Integer> answers; // Set of integers user got.
}
