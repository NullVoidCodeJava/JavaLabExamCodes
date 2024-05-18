package tester;

import java.sql.SQLException;
import java.util.Scanner;

import entity.Account;
import entity.User;
import exception.InvalidAccountException;
import exception.InvalidUserException;
import service.BankOperation;
import service.BankOperationImple;

public class Tester {

	private static final Scanner scanner = new Scanner(System.in);
    private static BankOperation bankOperation = new BankOperationImple();

	public static void main(String[] args) throws SQLException, InvalidAccountException, InvalidUserException {
    	
            int choice;
            
            do {
                System.out.println("Menu:");
                System.out.println("0. Exit");
                System.out.println("1. Add User");
                System.out.println("2. Add Accounts");
                System.out.println("3. Display user with their Accounts");
                System.out.println("4. Delete User");
                System.out.println("5. Search account using name");
                System.out.print("Enter your choice: ");
                
                choice = scanner.nextInt();
                
                scanner.nextLine();

                switch (choice) {
                
                    case 0:
                    {
                        scanner.close();
                        System.exit(0);
                        break;
                    }
                  
                    //add user
                    case 1:
                    {
                    
                        System.out.println("Enter your email: ");
                        String useremail = scanner.nextLine();
                        System.out.println("Enter your password ");
                        String userpassword = scanner.nextLine();
                        
                        bankOperation.addUser(new User(useremail, userpassword));
                        break;
                    }
                        
                    //Add Accounts
                    case 2:
                    {
                    	 System.out.println("Enter no of accounts to add: ");
                    	 int noOfAccounts = scanner.nextInt();
                    	 
                    	 for(int i = 1; i <= noOfAccounts; i++)
                    	 {
                    		 scanner.nextLine();
                    		 System.out.println("Enter account type (Enter savings or current): ");
                             String accountName = scanner.nextLine();
                 
                             System.out.println("Enter account email: ");
                             String accountEmail = scanner.nextLine();
                             System.out.println("Enter phone no: ");
                             String phoneNo = scanner.nextLine();
                             System.out.println("Enter account balance: ");
                             double accountBalance = scanner.nextDouble();
                             System.out.println("Enter userid");
                             int userId = scanner.nextInt();
                             
                             bankOperation.addAccount(new Account(accountName, accountEmail, phoneNo, accountBalance, userId));
                    	 }
                    
                        break;
                    }
                    
                    //display user with their Accounts
                    case 3:
                    {
                        System.out.println("Enter user id: ");
                        int userId = scanner.nextInt();
                        bankOperation.displayUserWithAccounts(userId);
                        break;
                    }
                    
                    //delete User
                    case 4:
                    	System.out.println("Enter user id: ");
                    	int userId = scanner.nextInt();
                    	bankOperation.deleteUser(userId);
                        break;
                        
                    //search account using name
                    case 5:
                    	System.out.println("Enter account name: ");
                    	String accountName = scanner.nextLine();
                    	bankOperation.searchAccountByName(accountName);
                        break;

    }
                    }while(choice != 0);
	}
}