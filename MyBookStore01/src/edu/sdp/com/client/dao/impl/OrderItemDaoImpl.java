package edu.sdp.com.client.dao.impl;

import edu.sdp.com.beans.OrderItem;
import edu.sdp.com.client.dao.BaseDao;
import edu.sdp.com.client.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	@Override
	public void saveOrderItem(Object[][] objects) {
		// | id | COUNT | amount | title | author | price | img_path | order_id
		String sql = "insert into order_items(COUNT,amount,title,author,price,img_path,order_id) values(?,?,?,?,?,?,?)";
		batch(sql, objects);
	}

}
