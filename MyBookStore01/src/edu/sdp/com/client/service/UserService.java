package edu.sdp.com.client.service;

import edu.sdp.com.beans.User;

/**
 * 用户和管理员登陆
 * 
 * @author 王大锤
 *
 */
public interface UserService {
	/**
	 * 如果有该用户返回true
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract User login(String username, String password);

	public abstract boolean getUserByName(String username);
}
