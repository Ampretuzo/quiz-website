package model;

import java.util.Set;

/**
 * This class encapsulates user data.
 * 
 * @author sergi
 *
 */
public class User {

	private String userName;
	private String hexPassword;
	private Set<String> friends; // Set of friends userNames of this user.
	
	/**
	 * User ctor.
	 * 
	 * @param userName - String user name
	 */
	public User(String userName, String hexPassword) {
		this.userName = userName;
		setHexPassword(hexPassword);
	}
	
	/**
	 * @return the hexPassword
	 */
	public String getHexPassword() {
		return hexPassword;
	}
	
	/**
	 * @param hexPassword the hexPassword to set
	 */
	public void setHexPassword(String hexPassword) {
		this.hexPassword = hexPassword;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
}
