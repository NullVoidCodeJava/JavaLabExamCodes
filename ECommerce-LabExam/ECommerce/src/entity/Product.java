/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 03:07 pm
 **/

package entity;

import java.util.Objects;

public class Product {

  private int id;
  private String name;
  private Category category;
  private double price;
  private boolean inStock;

  public Product(int id, String name, Category category, double price, boolean inStock) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
    this.inStock = inStock;
  }

  public Product() {
  }

  public Product(int id) {
    this.id = id;
  }

  //providing the getter and setters for all fields might require to change the product details

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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public boolean isInStock() {
    return inStock;
  }

  public void setInStock(boolean inStock) {
    this.inStock = inStock;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", category=" + category +
        ", price=" + price +
        ", inStock=" + inStock +
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
    Product product = (Product) o;
    return id == product.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
