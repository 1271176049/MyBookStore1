package edu.sdp.com.client.service.impl;

import edu.sdp.com.beans.Order2;
import edu.sdp.com.client.dao.OrderDao2;
import edu.sdp.com.client.dao.impl.OrderDaoImpl2;
import edu.sdp.com.client.service.OrderService2;

public class OrderServiceImpl2 implements OrderService2 {
private OrderDao2 orderDao2=new OrderDaoImpl2();
	@Override
	public Order2 getOrder2(String id) {
		// TODO Auto-generated method stub
		return orderDao2.getOrder2(id);
	}

}
