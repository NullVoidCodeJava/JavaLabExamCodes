/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 03:10 pm
 **/

package dao;

import entity.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtil;

public class SellerDao implements AutoCloseable {

  //connection to the database to be injected from DBUtil
  private Connection connection;

  public SellerDao() {
    try {
      connection = DBUtil.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  //insert seller into database
  public int addSeller(Seller seller) {
    String insertIntoSeller = "insert into seller(name, email, password, address) values(?,?,?,?)";
    int noOfRowsAffected = -1;
    try (PreparedStatement preparedStatement = connection.prepareStatement(insertIntoSeller)) {
      preparedStatement.setString(1, seller.getName());
      preparedStatement.setString(2, seller.getEmail());
      preparedStatement.setString(3, seller.getPassword());
      preparedStatement.setString(4, seller.getAddress());
      noOfRowsAffected = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return noOfRowsAffected;
  }

  //update seller details
  public int updateSeller(Seller seller) {
    String updateSeller = "update seller set name=?, email=?, password=?, address=? where id=?";
    int noOfRowsAffected = -1;
    try (PreparedStatement preparedStatement = connection.prepareStatement(updateSeller)) {
      preparedStatement.setString(1, seller.getName());
      preparedStatement.setString(2, seller.getEmail());
      preparedStatement.setString(3, seller.getPassword());
      preparedStatement.setString(4, seller.getAddress());
      preparedStatement.setInt(5, seller.getId());
      noOfRowsAffected = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return noOfRowsAffected;
  }

  //delete seller for database
  public int deleteSeller(int id) {
    String deleteSeller = "delete form seller where id=?";
    int noOfRowsAffected = -1;
    try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSeller)) {
      preparedStatement.setInt(1, id);
      noOfRowsAffected = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return noOfRowsAffected;
  }

  //delete seller by his name
  public int deleteSellerByName(String name) {
    String deleteSellerByName = "delete from seller where name=?";
    int noOfRowsAffected = -1;
    try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSellerByName)) {
      preparedStatement.setString(1, name);
      noOfRowsAffected = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return noOfRowsAffected;
  }

  //delete all seller,, HAHA
  public int deleteAllUsers() {
    String deleteAllSellers = "delete from seller";
    int noOfRowsAffected = -1;
    try (PreparedStatement preparedStatement = connection.prepareStatement(deleteAllSellers)) {
      noOfRowsAffected = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return noOfRowsAffected;
  }

  //find the seller by his id
  public Seller findSellerById(int id) {
    String findSellerById = "select * from seller where id=?";
    Seller seller = new Seller();
    try (PreparedStatement preparedStatement = connection.prepareStatement(findSellerById)) {
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();

      seller.setId(rs.getInt(1));
      seller.setName(rs.getString(2));
      seller.setEmail(rs.getString(3));
      seller.setPassword(rs.getString(4));
      seller.setAddress(rs.getString(5));

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return seller;
  }

  //find the seller by his name
  public Seller findSellerByName(String name) {
    String findSellerByName = "select * from seller where name=?";
    Seller seller = new Seller();
    try (PreparedStatement preparedStatement = connection.prepareStatement(findSellerByName)) {
      preparedStatement.setString(1, name);

      ResultSet rs = preparedStatement.executeQuery();

      seller.setId(rs.getInt(1));
      seller.setName(rs.getString(2));
      seller.setEmail(rs.getString(3));
      seller.setPassword(rs.getString(4));
      seller.setAddress(rs.getString(5));

      return seller;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Seller> findAllSellers() {
    String findAllSellers = "select * from seller";
    List<Seller> studentsList = new ArrayList<Seller>();
    Seller seller;
    try (PreparedStatement preparedStatement = connection.prepareStatement(findAllSellers)) {
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        seller = new Seller();
        seller.setId(rs.getInt(1));
        seller.setName(rs.getString(2));
        seller.setEmail(rs.getString(3));
        seller.setPassword(rs.getString(4));
        seller.setAddress(rs.getString(5));

        studentsList.add(seller);
      }
      return studentsList;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return studentsList;
  }

  public Seller loginSeller(String email, String password) {
    String loginSeller = "select * from seller where email=? and password=?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(loginSeller)) {
      preparedStatement.setString(1, email);
      preparedStatement.setString(2, password);
      ResultSet rs = preparedStatement.executeQuery();

      Seller seller = new Seller();
      seller.setId(rs.getInt(1));
      seller.setName(rs.getString(2));
      seller.setEmail(rs.getString(3));
      seller.setPassword(rs.getString(4));
      seller.setAddress(rs.getString(5));

      return seller;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Seller changePassword(String email, String password) {
    String changePassword = "update seller set password=? where email=?";
    Seller seller;
    try (PreparedStatement preparedStatement = connection.prepareStatement(changePassword)) {
      preparedStatement.setString(1, password);
      preparedStatement.setString(2, email);
      ResultSet rs = preparedStatement.executeQuery();

      seller = new Seller();
      seller.setId(rs.getInt(1));
      seller.setName(rs.getString(2));
      seller.setEmail(rs.getString(3));
      seller.setPassword(rs.getString(4));
      seller.setAddress(rs.getString(5));

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return seller;
  }

  @Override
  public void close() throws Exception {
    if (connection != null) {
      connection.close();
    }
  }
}
