package edu.sdp.com.client.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.sdp.com.beans.Order2;
import edu.sdp.com.beans.OrderItem;
import edu.sdp.com.beans.User;
import edu.sdp.com.client.dao.OrderDao2;
import edu.sdp.com.utils.JdbcUtils;

public class OrderDaoImpl2 implements OrderDao2 {
	/**
	 * 使用原生的JDBC，因为BaseDao满足不了我们的要求
	 */
	@Override
	public Order2 getOrder2(String id) {
		Connection connection = JdbcUtils.getConnection();
		Order2 order2 = new Order2();
		// String sql = "select u.id uId,u.username,u.email,o.id
		// oId,o.order_time,o.total_count,o.total_amount,o.state,i.id
		// iId,i.COUNT iCount,i.amount
		// iAmount,i.title,i.author,i.price,i.img_path imgPath from users u left
		// join orders o on u.id=o.user_id left join order_items i on
		// o.id=i.order_id where o.id='1509530795847-3'";
		String sql = "select u.id uId,u.username,u.email,o.id oId,o.order_time,o.total_count,o.total_amount,o.state,i.id iId,i.COUNT iCount,i.amount iAmount,i.title,i.author,i.price,i.img_path imgPath from users u left join orders o on u.id=o.user_id left join order_items i on o.id=i.order_id where o.id=?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, id);
			ResultSet set = prepareStatement.executeQuery();

			ArrayList<OrderItem> list = new ArrayList<>();
			while (set.next()) {
				int uId = set.getInt("uId");// 用户id
				String username = set.getString("username");// 用户名
				String email = set.getString("email");// 邮箱
				String oId = set.getString("oId");// 订单id
				String orderTime = set.getString("order_time");// 订单时间
				int totalCount = set.getInt("total_count");// 订单购买的图书的总数量
				double totalAmount = set.getDouble("total_amount");// 订单的总金额
				int state = set.getInt("state");// 订单的状态
				order2.setUser(new User(uId, username, "", email));
				order2.setId(oId);
				SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = sf2.parse(orderTime);
				System.out.println("日期格式化后："+date);
				order2.setOrderTime(date);
				order2.setTotalCount(totalCount);
				order2.setTotalAmount(totalAmount);
				order2.setState(state);
				// id iId,i.COUNT iCount,i.amount
				// iAmount,i.title,i.author,i.price,i.img_path imgPath
				int iId = set.getInt("iId");// 购物项id
				int iCount = set.getInt("iCount");// 购物项中图书的数量
				double iAmount = set.getDouble("iAmount");// 购物项的金额
				String title = set.getString("title");
				String author = set.getString("author");
				double price = set.getDouble("price");
				String imgPath = set.getString("imgPath");
				list.add(new OrderItem(iId, iCount, iAmount, title, author, price, imgPath, oId));
			}
			order2.setOrderItems(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return order2;
	}

}
