package edu.sdp.com.client.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sdp.com.beans.Order;
import edu.sdp.com.beans.User;
import edu.sdp.com.client.dao.BaseDao;
import edu.sdp.com.client.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public void saveOrder(Order order) {
		// | id | order_time | total_count | total_amount | state | user_id |
		String sql = "insert into orders values(?,?,?,?,?,?)";
		update(sql, order.getId(), order.getOrderTime(), order.getTotalCount(), order.getTotalAmount(),
				order.getState(), order.getUserId());
	}

	@Override
	public List<Order> getOrders(User user) {
		String sql = "select id,order_time orderTime,total_count totalCount,total_amount totalAmount,state,user_id userId from orders where user_id=?";
		List<Order> beanList = getBeanList(sql, user.getId());
		return beanList;
	}

	

}
