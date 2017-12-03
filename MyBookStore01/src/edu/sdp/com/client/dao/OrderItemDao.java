package edu.sdp.com.client.dao;

import edu.sdp.com.beans.CartItem;
import edu.sdp.com.beans.Order;

public interface OrderItemDao {
	// | id | COUNT | amount | title | author | price | img_path | order_id |
	public abstract void saveOrderItem(Object[][] objects);

}
