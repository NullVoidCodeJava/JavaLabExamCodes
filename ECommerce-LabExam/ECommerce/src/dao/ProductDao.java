/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 08:28 pm
 **/

package dao;

import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtil;

public class ProductDao {

  //connection to the database to be injected from DBUtil
  private Connection connection;

  public ProductDao() {
    try {
      connection = DBUtil.getConnection();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  //insert product into database
  public int addProduct(Product product) {
    String insertIntoProduct = "insert into product(name, category, price, in_stock) values(?,?,?,?)";
    int noOfRowsAffected = -1;

    try (PreparedStatement preparedStatement = connection.prepareStatement(insertIntoProduct)) {
      preparedStatement.setString(1, product.getName());
      preparedStatement.setString(2, product.getCategory().toString());
      preparedStatement.setDouble(3, product.getPrice());
      preparedStatement.setBoolean(4, product.isInStock());
      noOfRowsAffected = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return noOfRowsAffected;
  }

  //update product details
  public int updateProduct(Product product) {
    String updateProduct = "update product set name=?, category=?, price=?, in_stock=? where id=?";
    int noOfRowsAffected = -1;
    try (PreparedStatement preparedStatement = connection.prepareStatement(updateProduct)) {
      preparedStatement.setString(1, product.getName());
      preparedStatement.setString(2, product.getCategory().toString());
      preparedStatement.setDouble(3, product.getPrice());
      preparedStatement.setBoolean(4, product.isInStock());
      preparedStatement.setInt(5, product.getId());
      noOfRowsAffected = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return noOfRowsAffected;
  }

  //delete product from database
  public int deleteProduct(int id) {
    String deleteProduct = "delete from product where id=?";
    int noOfRowsAffected = -1;
    try (PreparedStatement preparedStatement = connection.prepareStatement(deleteProduct)) {
      preparedStatement.setInt(1, id);
      noOfRowsAffected = preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return noOfRowsAffected;
  }

  //search product by category
  public List<Product> searchProductByCategory(Category category) {
    String searchProductByCategory = "select * from product where category=?";
    List<Product> products = new ArrayList<>();
    try (PreparedStatement preparedStatement = connection.prepareStatement(searchProductByCategory)) {
      preparedStatement.setString(1, category.toString());
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setCategory(Category.valueOf(resultSet.getString("category")));
        product.setPrice(resultSet.getDouble("price"));
        product.setInStock(resultSet.getBoolean("in_stock"));
        products.add(product);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return products;
  }

}
