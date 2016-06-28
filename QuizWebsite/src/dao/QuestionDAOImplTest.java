package dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import factory.ClassFactory;

public class QuestionDAOImplTest {

	private DAOInstances factory;
	private QuestionDAO questionDAO;
	private ClassFactory classFactory;

	@Before
	public void setUp() throws Exception {
		factory = new DAOInstances();
		factory.init();
		//questionDAO = factory.getQuestionDAO();
		classFactory = new ClassFactory();
	}

	@Test
	public void test() {
//		Set<String> set = new HashSet<String>();
//		set.add("bonapart");
//		set.add("neipl");
//		questionDAO.addQR(4, classFactory.getQuestionQR("didie", 2, set));
		questionDAO.getQuestions(4);
		System.out.println(questionDAO.getQuestions(4));
	}

}
