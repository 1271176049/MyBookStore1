package edu.sdp.com.client.service.impl;

import edu.sdp.com.beans.User;
import edu.sdp.com.client.dao.UserDao;
import edu.sdp.com.client.dao.impl.UserDaoImpl;
import edu.sdp.com.client.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {

		return userDao.getUser(username, password);
	}

	@Override
	public boolean getUserByName(String username) {

		return userDao.getUser(username) != null;
	}

}
