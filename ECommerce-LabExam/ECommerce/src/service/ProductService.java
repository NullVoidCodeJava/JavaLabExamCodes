/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 03:42 pm
 **/

package service;

import dao.ProductDao;
import entity.Category;
import entity.Product;

public class ProductService {

  private ProductDao productDao;

  public ProductService() {
    productDao = new ProductDao();
  }

  public void addProduct(Product product) {
    //take the input from user, create the object and pass it to dao
    productDao.addProduct(product);
  }

  public void updateProduct(Product product) {
    productDao.updateProduct(product);
  }

  public void deleteProduct(int productId) {
    productDao.deleteProduct(productId);
  }

  //search product by category
  public void searchProductByCategory(String category) {
    productDao.searchProductByCategory(Category.valueOf(category));
  }


}
