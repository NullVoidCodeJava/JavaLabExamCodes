package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Batch;
import util.DbUtil;

public class BatchDao implements AutoCloseable {

	private Connection conn;

	public BatchDao() throws SQLException {
		this.conn = DbUtil.getConnection();
	}

	//insert a batch into database
	public int addBatch(Batch batch) throws SQLException {

		String query = "INSERT INTO batches (name, course) VALUES (?, ?)";

		int noOfRowsAffected = 0;

		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, batch.getName());
			stmt.setString(2, batch.getCourse());
			noOfRowsAffected = stmt.executeUpdate();
		}
		return noOfRowsAffected;
	}

	//display all batches from database
	public void displayAllBatches() throws SQLException {
		String query = "SELECT * FROM batches";
		try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Course: "
						+ rs.getString("course"));
//				Batch batch = new Batch();
//				batch.setId(rs.getInt("id"));
			}
		}
	}

	@Override
	public void close() throws Exception {
    if(conn != null)
    	conn.close();
	}
}