package service;

import java.sql.SQLException;

import entity.Account;
import entity.User;
import exception.InvalidAccountException;
import exception.InvalidUserException;

public interface BankOperation {

    void addUser(User user) throws SQLException, InvalidUserException;

    void addAccount(Account account) throws SQLException, InvalidAccountException;

    void displayUserWithAccounts(int userid) throws SQLException;

    void deleteUser(int userid) throws SQLException;

    void searchAccountByName(String name) throws SQLException;
}