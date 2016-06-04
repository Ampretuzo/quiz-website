package problem.QR;

import problem.Abstract.Statement;

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
