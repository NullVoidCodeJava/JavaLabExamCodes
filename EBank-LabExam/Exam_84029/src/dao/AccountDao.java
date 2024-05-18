package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Account;
import util.DbUtil;

public class AccountDao implements AutoCloseable {
	private Connection conn;

	public AccountDao() throws SQLException {
		this.conn = DbUtil.getConnection();
	}

	// method to add an account to the database
	public int addAccount(Account account) throws SQLException {

		String query = "INSERT INTO account (name, email, phone, balance, userid) VALUES (?, ?, ?, ?, ?)";

		int noOfRowsAffected = 0;

		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, account.getName());
			stmt.setString(2, account.getEmail());
			stmt.setString(3, account.getPhone());
			stmt.setDouble(4, account.getBalance());
			stmt.setInt(5, account.getUserid());
			noOfRowsAffected = stmt.executeUpdate();
		}
		return noOfRowsAffected;
	}

	// Display user with their Accounts
	public void displayUserAccounts(int userid) throws SQLException {
		String query = "SELECT * FROM account WHERE userid =?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, userid);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setAccNumber(rs.getInt("accNumber"));
				account.setName(rs.getString("name"));
				account.setEmail(rs.getString("email"));
				account.setPhone(rs.getString("phone"));
				account.setBalance(rs.getDouble("balance"));
				account.setUserid(rs.getInt("userid"));
				System.out.println(account);
			}
		}
	}

	// search account using name
	public void searchAccountByName(String name) throws SQLException {
		String query = "SELECT * FROM account WHERE name =?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setAccNumber(rs.getInt("accNumber"));
				account.setName(rs.getString("name"));
				account.setEmail(rs.getString("email"));
				account.setPhone(rs.getString("phone"));
				account.setBalance(rs.getDouble("balance"));
				account.setUserid(rs.getInt("userid"));
				System.out.println(account);
			}
		}
	}
	
	//delete account when delte user
	public int deleteAccount(int userid) throws SQLException {
		
        int noOfRowsAffected = 0;
        
        String query = "DELETE FROM account WHERE userid = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userid);
            noOfRowsAffected = stmt.executeUpdate();
        }
       
        return noOfRowsAffected;
	}

	@Override
	public void close() throws Exception {
		if (conn != null)
			conn.close();

	}

}
