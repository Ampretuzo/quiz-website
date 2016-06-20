package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.User;

public class QuizWebsiteModelTest {

	private static final String LEVANA_NAME = "levana";
	private static final String LEVANA_HEX_PASSWORD = "ylevana";
	private static final String LEVANA_SALT = "ylevanma";
	private QuizWebsiteModel model;
	private User levana;
	
	@Before
	public void setUp() {
		model = QuizWebsiteModel.getInstance();
		levana = new User(LEVANA_NAME, LEVANA_HEX_PASSWORD, LEVANA_SALT);
	}
	
	// super basic test
	@Test
	public void test() {
		model.deleteUser(LEVANA_NAME);
		assertTrue(model.getUser(LEVANA_NAME) == null);
		model.addUser(levana);
		assertEquals(LEVANA_NAME, model.getUser(LEVANA_NAME).getUserName());
		model.deleteUser(LEVANA_NAME);
		assertTrue(model.getUser(LEVANA_NAME) == null);
	}
}
