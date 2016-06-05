package classes;

public abstract class Achievement {
	private String pictureURL;
	private String description;
	public abstract boolean userUnlocked(User user); // Return true if user met the requirements for achievement to unlock.
}
