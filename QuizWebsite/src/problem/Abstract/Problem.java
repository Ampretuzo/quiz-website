package problem.Abstract;

public abstract class Problem <T extends Answer>{

	/**
	 * Changes Answer's graded state to true and sets the grade with maximum grade.
	*/
	public abstract void setGrade(T answer);
	
	/**
	 * This function returns statement for user to see.
	 * @return problem Object;
	*/
	public abstract Statement getStatement();	
}
