package classes.problem.QR;

import classes.problem.Abstract.Statement;

public class StatementQR extends Statement {

private String description;
	
	public StatementQR(String newDescription)
	{
		description = newDescription;
	}
	
	public String getDescription()
	{
		return description;
	}
}
