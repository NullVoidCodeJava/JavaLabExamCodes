/**
 * @author : Vedant Chimote
 * @mailto : vedantc.code@gmail.com
 * @created : 08-05-2024, Wednesday
 * @Time : 03:47 pm
 **/

package exception;

public class SellerNotFoundException extends Exception {

  public long serialVersionUID = 1L;

  public SellerNotFoundException(String message) {
    super(message);
  }

}
