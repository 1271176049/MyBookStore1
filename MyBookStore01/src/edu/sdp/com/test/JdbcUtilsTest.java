package edu.sdp.com.test;

import org.junit.Test;

import edu.sdp.com.beans.Order2;
import edu.sdp.com.client.dao.OrderDao2;
import edu.sdp.com.client.dao.impl.OrderDaoImpl2;
import edu.sdp.com.utils.JdbcUtils;

public class JdbcUtilsTest extends JdbcUtils {

	@Test
	public void test1() {
		OrderDao2 orderDaoImpl2 = new OrderDaoImpl2();
		Order2 order2 = orderDaoImpl2.getOrder2("1509530795847-3");
		System.out.println(order2);
		order2.getOrderItems().forEach(System.out::println);
	}

}
