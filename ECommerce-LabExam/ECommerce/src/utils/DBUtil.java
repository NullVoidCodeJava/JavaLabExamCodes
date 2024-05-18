/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 03:06 pm
 **/

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

  private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_lab";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "root";

  public static Connection getConnection() throws SQLException{
//    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_lab", "root",
        "root");
  }

}
