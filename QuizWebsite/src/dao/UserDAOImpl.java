package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import classes.User;

public class UserDAOImpl implements UserDAO {

	DataSource dataSource;
	
	private static final String USER_NAME = "user_name";

	private static final String HEX_PASSWORD = "hex_password";

	private static final String USER_TABLE = "user";

	private static final String SALT = "salt";

	private static final String STATUS = null;
	
	public UserDAOImpl() {
		dataSource = null;	// TODO: needs singleton data source
	}
	
	@Override
	public User getUser(String userName) {
		User user = null;
		String command = "SELECT * FROM " + 
				USER_TABLE + " WHERE " + 
				USER_NAME + " LIKE ?;";
		try {
			Connection con = dataSource.getConnection();
			java.sql.PreparedStatement preparedStatement = 
					con.prepareStatement(command);
			preparedStatement.setString(1, userName);
			ResultSet rs = preparedStatement.executeQuery();
			// we need only one row (there should not be more)
			if(rs.next()) {
				user = new User(rs.getString(USER_NAME),
						rs.getString(HEX_PASSWORD),
						rs.getString(SALT));
				// TODO: add other information
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User deleteUser(String userName) {
		User oldUser = getUser(userName);
		// return null if there is no such user
		if(oldUser == null) return null;
		
		String command = "DELETE FROM " + 
				USER_TABLE + " WHERE " + 
				USER_NAME + " LIKE ?;";
		
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement preparedStatement = 
					con.prepareStatement(command);
			preparedStatement.setString(1, userName);
			preparedStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oldUser;
	}

	@Override
	public User updateUser(User user) {
		User oldUser = getUser(user.getUserName());
		// return null if there is no such user
		if(oldUser == null) return null;	
		
		deleteUser(user.getUserName());
		addUser(user.getUserName(),
				user.getHashedPassword(),
				user.getSalt());

//		String command = "UPDATE " + USER_TABLE + "SET " + ""; 
//		try {
//			Connection con = dataSource.getConnection();
//			PreparedStatement preparedStatement = 
//					con.prepareStatement(command);
//			preparedStatement.setString(1, userName);
//			preparedStatement.executeUpdate();
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return oldUser;
	}

	@Override
	public User addUser(String userName, String hexPassword, String salt) {
		User newUser = null;
		newUser = getUser(userName);
		if(newUser == null) return null;
		
		String command = "INSERT INTO " + 
				USER_TABLE + " (" + 
				USER_NAME + ", " + 
				HEX_PASSWORD + ", " + 
				SALT + ") VALUES(?, ?, ?);";
		try {
			Connection con = dataSource.getConnection();
			PreparedStatement preparedStatement =
					con.prepareStatement(command);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, hexPassword);
			preparedStatement.setString(3, salt);
			preparedStatement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getUser(userName);
	}

}
