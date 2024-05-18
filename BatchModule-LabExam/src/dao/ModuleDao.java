package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entity.Module;
import util.DbUtil;

public class ModuleDao implements AutoCloseable {
    private Connection conn;

    public ModuleDao() throws SQLException {
        this.conn = DbUtil.getConnection();
    }

    public int addModule(Module module) throws SQLException {
    
        String query = "INSERT INTO modules (name, start_date, days, faculty, batch_id) VALUES (?, ?, ?, ?, ?)";
        
        int noOfRowsAffected = 0;
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, module.getName());
            stmt.setDate(2, module.getStartDate());
            stmt.setInt(3, module.getDays());
            stmt.setString(4, module.getFaculty());
            stmt.setInt(5, module.getBatchId());
            noOfRowsAffected = stmt.executeUpdate();
        }
        return noOfRowsAffected;
    }

    public void displayModulesByBatchId(int batchId) throws SQLException {
    	
    	String query = "SELECT m.id, m.name, m.start_date, m.days, m.faculty,"
    			+ " m.batch_id FROM modules m INNER JOIN batches b ON m.batch_id = b.id WHERE b.id = ?";
    	
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, batchId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
            	Module module = new Module();
                module.setId(rs.getInt("id"));
                module.setName(rs.getString("name"));
                module.setStartDate(rs.getDate("start_date"));
                module.setDays(rs.getInt("days"));
                module.setFaculty(rs.getString("faculty"));
                module.setBatchId(rs.getInt("batch_id"));
                
                System.out.println(module);
            }
        }
    }

    public int deleteModuleByName(String moduleName) throws SQLException {
    	
    	int noOfRowsAffected = 0;
    	
        String query = "DELETE FROM modules WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, moduleName);
           noOfRowsAffected = stmt.executeUpdate();
        }
        return noOfRowsAffected;
    }

    public int updateModule(Module module) throws SQLException {
        
    	int noOfRowsAffected = 0;
    	
    	String query = "UPDATE modules SET name = ?, start_date = ?, days = ?, faculty = ?, batch_id = ?"
    			+ " WHERE id = ?";
       
    	try (PreparedStatement stmt = conn.prepareStatement(query)) {
        	stmt.setString(1, module.getName());
            stmt.setDate(2, module.getStartDate());
            stmt.setInt(3, module.getDays());
            stmt.setString(4, module.getFaculty());
            stmt.setInt(5, module.getBatchId());
            stmt.setInt(6, module.getId());
            
           noOfRowsAffected = stmt.executeUpdate();
        }
    	
    	return noOfRowsAffected;
    }
    
  //display modulewise total days for given batch id
    public void displayModulewiseTotalDays(int batchId) throws SQLException {
        String query = "SELECT name, SUM(days) AS total_days FROM modules WHERE batch_id = ? GROUP BY name";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, batchId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Module wise total days for module " + rs.getString("name")+ " are " + rs.getInt("total_days"));
            }
        }
    }
    
   //display number of days for each course for each faculty
    public void displayNumberOfDaysForEachCourseForEachFaculty() throws SQLException {
    	String query = "SELECT b.name AS batch_name, m.name AS module_name, SUM(m.days) AS total_days " +
                "FROM batches b INNER JOIN modules m ON b.id = m.batch_id " +
                "GROUP BY b.name, m.name, m.faculty";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Module: " + rs.getString("module_name") + ", Total Days: " + rs.getInt("total_days"));
            }
        }
    }

@Override
public void close() throws Exception {
	  if(conn != null)
	    	conn.close();
	
}

}
