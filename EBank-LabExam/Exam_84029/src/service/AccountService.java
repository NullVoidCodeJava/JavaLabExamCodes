package service;

import java.sql.SQLException;

import dao.AccountDao;
import entity.Account;

public class AccountService {

	private AccountDao accountDao;

	public AccountService() {
		super();
		try {
			this.accountDao = new AccountDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//add account
	public int addAccount(Account account) {
		try {
			return this.accountDao.addAccount(account);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	// Display user with their Accounts
	public void displayUserAccounts(int userid) {
		try {
			this.accountDao.displayUserAccounts(userid);
			//this.accountDao.deleteAccount(userid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// search account using name
	public void searchAccountByName(String name) {
		try {
			this.accountDao.searchAccountByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
