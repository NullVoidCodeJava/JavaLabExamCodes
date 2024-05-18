package tester;

import java.util.Scanner;
import service.ProductService;
import service.SellerService;

public class Main {

  private static Scanner scanner = new Scanner(System.in);
  private static int choice = 0;
  private static SellerService sellerService = new SellerService();
  private static ProductService productService = new ProductService();

  public static void main(String[] args) {
    //menu driven program

    sellerService.findSellerById(1);

  }
}