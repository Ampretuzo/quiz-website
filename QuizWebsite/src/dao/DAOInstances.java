package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;  // Usual.

//import org.apache.tomcat.dbcp.dbcp2.BasicDataSource; // Online.

/**
 * This class is probably not quite factory, hence the name.
 * 
 * @author sergi
 *
 */
public class DAOInstances {

	private BasicDataSource dataSource;
	
	public DAOInstances() {
		dataSource = null;
	}
	
	/**
	 * Call this before using any of the methods.
	 */
	public void init() {
		// TODO: move all these strings as constants
		dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("558751");
		dataSource.setUrl("jdbc:mysql://localhost:3306/oop");
		// we can control how connection pool behaves
		dataSource.setMaxIdle(20);
	}
	
	public UserDAO getUserDAO() {
		return new UserDAOImpl(dataSource);
	}
	
	public QuizDAO getQuizDAO() {
		return new QuizDAOImpl(dataSource);
	}
	
}
