package Tests.Classes.Question;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import classes.question.QuestionMC;

public class QuestionMCTest {

	private Set<String> wrongAnswers;
	private String description;
	private String correctAnswer;
	private int grade;
	private List<String> userAnswer;
	private QuestionMC question;
	
	@Before
	public void init()
	{
		userAnswer = new ArrayList<String>(); 	
		wrongAnswers = new HashSet<String>();
		
		wrongAnswers.add("b");
		wrongAnswers.add("c");
		wrongAnswers.add("d");
		
		description = "Problem";
		correctAnswer = "a";
		grade = 5;
		
		question = new QuestionMC(description, grade, correctAnswer, wrongAnswers);
		System.out.println(question.toString());
	}
	
	@Test
	public void testCorrectAnswers() {
		assertEquals((int)question.getGrade(question.getCorrectAnswers()), (int)question.getMaxGrade());
	}

	@Test
	public void testBasic() {
		assertEquals(1, question.getCorrectAnswers().size());
		assertEquals(grade, question.getGrade());	
		assertEquals(grade, question.getMaxGrade());
		assertEquals(description, question.getProblem());
		assertTrue(question.getWrongAnswers().equals(wrongAnswers));
		assertTrue(question.getCorrectAnswers().get(0).equals(correctAnswer));
		assertTrue(question.getCorrectAnswer().equals(correctAnswer));
	}
	
	@Test
	public void testGetAllAnswers() { 
		assertTrue(question.getAllAnswers().containsAll(question.getWrongAnswers()));
		assertTrue(question.getAllAnswers().contains(question.getCorrectAnswer()));
		assertEquals(question.getAllAnswers().size(), question.getWrongAnswers().size() + 1);
	}
	
	@Test
	public void testGetGrade1() { 
		userAnswer.add("a");	
		assertEquals(grade, (int)question.getGrade(userAnswer));
	}
	
	@Test
	public void testGetGrade2() { 
		userAnswer.add("b");	
		assertEquals(0, (int)question.getGrade(userAnswer));
	}
	
	@Test
	public void testGetGrade3() { 
		userAnswer.add("l");	
		assertEquals(0, (int)question.getGrade(userAnswer));
	}

	@Test(expected=IllegalArgumentException.class)
	public void illegalArgumentTest1() { 	
		correctAnswer = null;
		new QuestionMC(description, grade, correctAnswer, wrongAnswers);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void illegalArgumentTest2() { 	
		wrongAnswers = null;
		new QuestionMC(description, grade, correctAnswer, wrongAnswers);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void illegalArgumentTest3() { 	
		wrongAnswers.add(null);
		new QuestionMC(description, grade, correctAnswer, wrongAnswers);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void illegalArgumentTest6() { 
		userAnswer = null;
		question.getGrade(userAnswer);
	}
}
