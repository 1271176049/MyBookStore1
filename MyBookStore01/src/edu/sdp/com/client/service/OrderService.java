package edu.sdp.com.client.service;

import java.util.List;

import edu.sdp.com.beans.Cart;
import edu.sdp.com.beans.Order;
import edu.sdp.com.beans.User;

public interface OrderService {
	public abstract String saveOrder(User user, Cart cart);

	public abstract List<Order> getOrders(User user);
}
