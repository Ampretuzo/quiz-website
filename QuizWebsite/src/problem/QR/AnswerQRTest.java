package problem.QR;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnswerQRTest {

	@Test
	public void test() {
		AnswerQR answer = new AnswerQR(0, "MyAnswer");
		assertTrue(((String)answer.getAnswer()).equals("MyAnswer"));
		assertTrue(answer.isGraded() == false);
		assertTrue(answer.getGrade() == null);
		
		answer.setGrade(10);
		assertTrue(answer.isGraded() == true);
		assertTrue(answer.getGrade() == 10);	
		assertTrue(answer.getTestId() == 0);
	}
}