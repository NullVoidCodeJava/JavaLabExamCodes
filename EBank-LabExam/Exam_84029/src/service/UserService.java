package service;

import java.sql.SQLException;

import dao.UserDao;
import entity.User;

public class UserService {

	private UserDao userDao;

	//initialize the userDao
	public UserService() {
		super();
		try {
			this.userDao = new UserDao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//add a user to database
	public int addUser(User user) {
		try {
			userDao.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//delete a user By id
	public void deleteUserById(int id) {
			try {
            userDao.deleteUserById(id);
     
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
