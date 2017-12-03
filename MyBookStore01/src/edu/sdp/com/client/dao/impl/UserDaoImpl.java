package edu.sdp.com.client.dao.impl;

import edu.sdp.com.beans.User;
import edu.sdp.com.client.dao.BaseDao;
import edu.sdp.com.client.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUser(String username, String password) {
		String sql = "select id,username,password,email from users where username=? and password=?";
		User bean = getBean(sql, username, password);
		return bean;
	}

	@Override
	public User getUser(String username) {
		String sql = "select id,username,password,email from users where username=?";
		System.out.println(username);
		User bean = getBean(sql, username);
		System.out.println("dao" + bean);
		return bean;
	}

}
