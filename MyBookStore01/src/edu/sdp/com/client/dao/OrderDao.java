package edu.sdp.com.client.dao;

import java.util.List;

import edu.sdp.com.beans.Order;
import edu.sdp.com.beans.User;

public interface OrderDao {
	// | id | order_time | total_count | total_amount | state | user_id |
	public abstract void saveOrder(Order order);

	public abstract List<Order> getOrders(User user);
	
}
