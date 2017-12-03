package edu.sdp.com.client.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.sdp.com.beans.Book;
import edu.sdp.com.beans.Cart;
import edu.sdp.com.beans.CartItem;
import edu.sdp.com.beans.Order;
import edu.sdp.com.beans.User;
import edu.sdp.com.client.dao.BookDao;
import edu.sdp.com.client.dao.OrderDao;
import edu.sdp.com.client.dao.OrderItemDao;
import edu.sdp.com.client.dao.impl.BookDaoImpl;
import edu.sdp.com.client.dao.impl.OrderDaoImpl;
import edu.sdp.com.client.dao.impl.OrderItemDaoImpl;
import edu.sdp.com.client.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();

	@Override
	public String saveOrder(User user, Cart cart) {
		// 根据用户名和时间生成唯一的订单号
		Integer id = user.getId();
		String orderId = System.currentTimeMillis() + "-" + id;
		// 保存訂單
		// | id | order_time | total_count | total_amount | state | user_id |
		Order order = new Order(orderId, new Date(), cart.getTotalCount(), cart.getTotalAmount(), 0, id);
		orderDao.saveOrder(order);
		// 保存訂單項
		// | id | COUNT | amount | title | author | price | img_path | order_id
		// |
		ArrayList<CartItem> cartItemList = cart.getCartItemList();
		Object[][] objects = new Object[cartItemList.size()][];
		for (int i = 0; i < cartItemList.size(); i++) {
			CartItem cartItem = cartItemList.get(i);
			Book book = cartItem.getBook();
			objects[i] = new Object[] { cartItem.getCount(), cartItem.getAmount(), book.getTitle(), book.getAuthor(),
					book.getPrice(), book.getImgPath(), orderId };
		}
		orderItemDao.saveOrderItem(objects);
		// 修改圖書的庫存和銷量
		Object[][] objects2 = new Object[cartItemList.size()][];
		for (int i = 0; i < cartItemList.size(); i++) {
			CartItem cartItem = cartItemList.get(i);
			Book book = cartItem.getBook();
			// 获取该购物项的购买数量，然后将改图书的库存和销量修改
			Integer count = cartItem.getCount();
			objects2[i] = new Object[] { book.getSales() + count, book.getStock() - count, book.getId() };
		}
		bookDao.updateBook(objects2);
		// 清空购物车
		cart.clear();
		return orderId;
	}

	@Override
	public List<Order> getOrders(User user) {
		
		return orderDao.getOrders(user);
	}

}
