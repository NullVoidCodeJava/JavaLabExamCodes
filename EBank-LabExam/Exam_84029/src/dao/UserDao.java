package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import entity.User;
import util.DbUtil;

public class UserDao implements AutoCloseable {

	private Connection conn;

	public UserDao() throws SQLException {
		this.conn = DbUtil.getConnection();
	}

	//insert a user into database
	public int addUser(User user) throws SQLException {

		String insertUser = "INSERT INTO user (email, password) VALUES (?, ?)";

		int noOfRowsAffected = 0;

		try (PreparedStatement stmt = conn.prepareStatement(insertUser)) {
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			noOfRowsAffected = stmt.executeUpdate();
		}
		return noOfRowsAffected;
	}

	//delete a User By id
	public int deleteUserById(int userid) throws SQLException, SQLIntegrityConstraintViolationException {
	  String deleteUser = "delete from user where userid=?";
	  int noOfRowsAffected = 0;
	  try (PreparedStatement preparedStatement = conn.prepareStatement(deleteUser)) {
	    preparedStatement.setInt(1, userid);
	    noOfRowsAffected = preparedStatement.executeUpdate();
	  } 
	  catch(SQLIntegrityConstraintViolationException e)
	  {
		  System.out.println("----------- Cannot delete a user having accounts -----------");
		  System.out.println("----------- First delete the associated accounts -----------");
		  e.printStackTrace();
	  }
	  catch (SQLException e) {
	    throw new RuntimeException(e);
	  }
	  return noOfRowsAffected;
	}
	
	  // Delete all accounts associated with the user
//	public int deleteUserById(int userid) throws SQLException {
//		  String deleteUser = "delete from user where userid=?";
//		  int noOfRowsAffected = 0;
//		  try (PreparedStatement preparedStatement = conn.prepareStatement(deleteUser)) {
//		    preparedStatement.setInt(1, userid);
//		    noOfRowsAffected = preparedStatement.executeUpdate();
//		  } catch (SQLException e) {
//		    throw new RuntimeException(e);
//		  }
//
//		  // Delete all accounts associated with the user
//		  String deleteAccountsByUserId = "delete from accounts where userid=?";
//		  try (PreparedStatement preparedStatement = conn.prepareStatement(deleteAccountsByUserId)) {
//		    preparedStatement.setInt(1, userid);
//		    int rowsAffected = preparedStatement.executeUpdate();
//		    if (rowsAffected > 0) {
//		      System.out.println("All accounts associated with the user have been deleted.");
//		    }
//		  } catch (SQLException e) {
//		    throw new RuntimeException(e);
//		  }
//
//		  return noOfRowsAffected;
//		}

	@Override
	public void close() throws Exception {
    if(conn != null)
    	conn.close();
	}
}