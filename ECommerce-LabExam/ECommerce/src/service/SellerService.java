/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 03:42 pm
 **/

package service;

import dao.SellerDao;
import entity.Seller;
import java.util.List;

public class SellerService {

  private SellerDao sellerDao;

  public SellerService() {
    sellerDao = new SellerDao();
  }

  public void addSeller(Seller seller) {
    sellerDao.addSeller(seller);
  }

  public void updateSeller(Seller seller) {
    sellerDao.updateSeller(seller);
  }

  public void deleteSeller(int id) {
    sellerDao.deleteSeller(id);
  }

  public void deleteSellerByName(String name)
  {
    sellerDao.deleteSellerByName(name);
  }

  public int deleteAllUsers() {
    return sellerDao.deleteAllUsers();
  }

  public Seller findSellerById(int id)
  {
   return sellerDao.findSellerById(id);
  }

  public Seller findSellerByName(String name) {
    return sellerDao.findSellerByName(name);
  }

  public List<Seller> findAllSellers() {
    return sellerDao.findAllSellers();
  }

  public Seller loginSeller(String email, String password) {
    return sellerDao.loginSeller(email, password);
  }

  public Seller changePassword(String email, String password) {
    return sellerDao.changePassword(email, password);
  }
}
