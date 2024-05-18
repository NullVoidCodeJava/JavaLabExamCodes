/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 03:49 pm
 **/

package exception;

public class ProductNotFoundException extends Exception {

  public long serialVersionUID = 1L;

  public ProductNotFoundException(String message) {
    super(message);
  }

}