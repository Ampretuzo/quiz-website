package dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import classes.Result;

public class ResultDAOImpl implements ResultDAO {

	private DataSource dataSource;
	
	public ResultDAOImpl(BasicDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insertResult(Result result) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Result> getResult(String userName, int quizId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> getRecentResults(String userName, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> getRecentResults(int quizId, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> getBestResults(String userName, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> getBestResults(int quizId, int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
