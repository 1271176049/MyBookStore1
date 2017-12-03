package edu.sdp.com.client.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sdp.com.beans.Cart;
import edu.sdp.com.beans.Order;
import edu.sdp.com.beans.Order2;
import edu.sdp.com.beans.User;
import edu.sdp.com.client.dao.OrderDao2;
import edu.sdp.com.client.dao.impl.OrderDaoImpl2;
import edu.sdp.com.client.service.OrderService;
import edu.sdp.com.client.service.impl.OrderServiceImpl;

public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService = new OrderServiceImpl();
	// 查询特殊的VO
	private OrderDao2 orderService2 = new OrderDaoImpl2();

	/**
	 * 结算
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void creatOrder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入结算的方法");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		String saveOrder = orderService.saveOrder(user, cart);
		// 将业务放到Service层
		request.setAttribute("orderId", saveOrder);
		request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
	}

	/**
	 * 用戶点击我的订单，进入我的订单，首先获取订单
	 * 
	 * @param request
	 * @param response
	 */
	public void intoOrder(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		ArrayList<Order> orderlist = null;
		if (user != null) {
			orderlist = (ArrayList<Order>) orderService.getOrders(user);
		}
		// 将订单列表返回给界面

		request.setAttribute("orderlist", orderlist);
		// 使用转发
		try {
			request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void getOrderItemsInfo(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		// 调用OrderService2层的方法获取Order2对象
		Order2 order2 = orderService2.getOrder2(id);
		// 将order2存放到request域中，然后通过转发到界面
		request.setAttribute("order2", order2);
		try {
			request.getRequestDispatcher("/pages/order/order_info.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
