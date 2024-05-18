/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 03:07 pm
 **/

package entity;

import java.util.Objects;

public class Seller {

  private int id;
  private String name;
  private String email;
  private String password;
  private String address;

  public Seller() {
  }

  public Seller(int id, String name, String email, String password, String address) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.address = address;
  }

  public Seller(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }
  //might require to change the password
  public void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Seller{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", address='" + address + '\'' +
        '}';
  }

  //checking the objects based on id
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Seller seller = (Seller) o;
    return id == seller.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
