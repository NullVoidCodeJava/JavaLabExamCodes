package service;

import java.sql.SQLException;

import entity.Account;
import entity.User;
import exception.InvalidAccountException;
import exception.InvalidUserException;

public class BankOperationImple implements BankOperation {
	
	private UserService userService;
	private AccountService accountService;
	
	public BankOperationImple() {
        userService = new UserService();
        accountService = new AccountService();
    }

	@Override
	public void addUser(User user) throws InvalidUserException{

	       // Validate the user
        if (user.getEmail() == null || user.getEmail().isEmpty() || !user.getEmail().contains("@")) {
            throw new InvalidUserException("Invalid email format. Please enter a valid email address.");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty() || user.getPassword().length() < 8) {
            throw new InvalidUserException("Password must be at least 8 characters long.");
        }

        // Add the user to the database
        this.userService.addUser(user);
		
	}

	@Override
	public void addAccount(Account account) throws SQLException, InvalidAccountException {
	

        if (account.getName() == null || account.getName().isEmpty()) {
            throw new InvalidAccountException("Account name cannot be empty.");
        }

        if (account.getEmail() == null || account.getEmail().isEmpty() || !account.getEmail().contains("@")) {
            throw new InvalidAccountException("Invalid email format. Please enter a valid email address.");
        }

        if (account.getPhone() == null || account.getPhone().isEmpty()) {
            throw new InvalidAccountException("Phone number cannot be empty.");
        }

        if (account.getBalance() <= 0) {
            throw new InvalidAccountException("Account balance must be a positive number.");
        }

        // Add the account to the database
        this.accountService.addAccount(account);
		
	}

	@Override
	public void displayUserWithAccounts(int userid) throws SQLException {
		
		this.accountService.displayUserAccounts(userid);
		
	}

	@Override
	public void deleteUser(int userid) throws SQLException {
		
		this.userService.deleteUserById(userid);
		
	}

	@Override
	public void searchAccountByName(String name) throws SQLException {
		
		this.accountService.searchAccountByName(name);
		
	}

}
