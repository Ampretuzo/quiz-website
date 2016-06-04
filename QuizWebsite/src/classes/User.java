package classes;

import java.util.Set;

public class User {
	private String status; // TODO enum; status of the user. "Ordinary", "Administration" etc.
	private String userName;
	private String hashedPassword;
	private Set<Integer> friends; // Set of user's friends.
	private Set<Integer> createdQuizes;	
	private Set<Integer> takenQuizes;
	private Set<Integer> achievements;
	private Set<Integer> messages; // Messages stored here. might change, depends on implementation	
}
