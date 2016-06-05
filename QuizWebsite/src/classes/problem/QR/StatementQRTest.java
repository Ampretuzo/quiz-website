package classes.problem.QR;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatementQRTest {

	@Test
	public void test() {
		String question = "What is the capital of Great Britain?";
		StatementQR problem = new StatementQR(question);
		assertEquals(question, problem.getDescription());
	}
}
