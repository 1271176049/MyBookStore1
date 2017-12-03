package edu.sdp.com.client.dao;

import edu.sdp.com.beans.User;

public interface UserDao {
public abstract User getUser(String username,String password);

public abstract User getUser(String username);
}
