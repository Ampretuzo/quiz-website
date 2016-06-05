package classes;

import java.util.HashSet;
import java.util.Set;

public class User {
	public User(String userName, String hashedPassword)
	{
		setUserName(userName);
		setHashedPassword(hashedPassword); // Set registration date.
		status = "regular"; // TODO change
		friends = new HashSet<Integer>();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}


	private String status; // TODO enum; status of the user. "Ordinary", "Administration" etc.
	private String userName;
	private String hashedPassword;
	private HashSet<Integer> friends; // Set of user's friends.
	private HashSet<Integer> createdQuizes;	
	private HashSet<Integer> takenQuizes;
	private HashSet<Integer> achievements;
	private HashSet<Integer> messages; // Messages stored here. might change, depends on implementation	
}
