package classes.problem.QR;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import classes.Answer;

public class ProblemQRTest {

	@Test
	public void test() {
		HashSet<String> answers = new HashSet<String>();
		answers.add("A");
		answers.add("B");
		String problem = "description";
		
		ProblemQR test = new ProblemQR(problem, answers);
		
		assertTrue(test.getAnswers().equals(answers)); // Testing if information is written without mistakes.
		assertTrue(test.getStatement().getDescription().equals(problem));
		
		assertEquals(1, (int)test.getGrade(new ArrayList<String>(){{  add("A"); }}));
		assertEquals(1, (int)test.getGrade(new ArrayList<String>(){{  add("B"); }}));
		assertEquals(0, (int)test.getGrade(new ArrayList<String>(){{  add("C"); }}));;
		assertEquals(null, test.getGrade(new ArrayList<String>(){{  add("B"); add("A"); }})); // Big length.
		assertEquals(null, test.getGrade(new ArrayList<String>(){{  }})); // Empty.
	}
}
