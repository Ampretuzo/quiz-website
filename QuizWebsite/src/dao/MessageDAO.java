package dao;

import java.util.List;

import classes.Message.Announcement;
import classes.Message.Challenge;
import classes.Message.FriendRequest;
import classes.Message.Note;

public interface MessageDAO {

	/**
	 * Adds note to database.
	 * 
	 * @param note - note to Add
	 */
	public void addNote(Note note);
	
	/**
	 * Adds a challenge to the database.
	 * 
	 * @param challenge - challenge to Add
	 */
	public void addChallenge(Challenge challenge);
	
	/**
	 * Adds a friend request to the database.
	 * 
	 * @param request - a request to Add
	 */
	public void addFriendRequest(FriendRequest request);
	
	/**
	 * Adds an announcement to the database.
	 * 
	 * @param announcement - announcement to add
	 */
	public void addAnnouncement(Announcement announcement);
	
	/**
	 * Returns user's received n notes sorted by date.
	 * 
	 * @param userName - receiver
	 * @param n - number of notes
	 * @return List of user's received notes sorted by date
	 */
	public List<Note> getReceivedNotes(String userName, int n);
	
	/**
	 * Returns user's sent n notes sorted by date.
	 * 
	 * @param userName - who's notes we return 
	 * @param n - number of notes
	 * @return List of user's sent notes sorted by date
	 */
	public List<Note> getSentNotes(String userName, int n);
	
	/**
	 * Returns user's received n challenges sorted by date.
	 * 
	 * @param userName - receiver
	 * @param n - number of challenges
	 * @return List of user's received challenges sorted by date
	 */
	public List<Challenge> getChallenge(String userName, int n);
	
	/**
	 * Returns user's received n friend requests sorted by date.
	 * 
	 * @param userName - receiver
	 * @param n - number of friend requests
	 * @return List of user's received friend requests sorted by date
	 */
	public List<Challenge> getFriendRequest(String userName, int n);
	
	/**
	 * Returns n announcements sorted by date.
	 * 
	 * @param n - number of friend requests
	 * @return List of user's received friend requests sorted by date
	 */
	public List<Announcement> getAnnouncements(int n);
	
	
}
