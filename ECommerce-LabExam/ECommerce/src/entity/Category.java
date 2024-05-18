/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 03:13 pm
 **/

package entity;

public enum Category {

  ELECTRONICS,
  FASHION,
  HOME_APPLIANCES,
  BOOKS,
  GROCERY,
  SPORTS,
  TOYS,
  BEAUTY,
  HEALTH,
  AUTOMOBILE,
  FURNITURE,
  STATIONARY,
  OTHERS;

  public static Category getCategory(String category) {
    return Category.valueOf(category.toUpperCase());
  }

  public static String getCategory(Category category) {
    return category.name().toLowerCase();
  }

}
