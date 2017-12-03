package edu.sdp.com.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sdp.com.beans.Book;
import edu.sdp.com.beans.Cart;
import edu.sdp.com.beans.CartItem;
import edu.sdp.com.client.service.BookService;
import edu.sdp.com.client.service.impl.BookServiceImpl;

public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();

	/**
	 * 修改购物项的数量
	 * 
	 * @param request
	 * @param response
	 */
	public void updateCartItem(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String count = request.getParameter("count");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		System.out.println("updateCartItem:" + id + ":" + count);
		Map<String, CartItem> map = cart.getMap();
		CartItem cartItem = map.get(id);
		cartItem.setCount(Integer.valueOf(count));
		try {
			response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 清空购物车
	 * 
	 * @param request
	 * @param response
	 */
	public void deleteCart(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// 清空购物车了
		session.removeAttribute("cart");
		try {
			response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除购物车中的购物项
	 * 
	 * @param request
	 * @param response
	 */
	public void deleteCartItem(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Map<String, CartItem> map = cart.getMap();
		// 删除对应的购物项
		map.remove(id);
		// 重定向到界面
		try {
			response.sendRedirect(request.getContextPath() + "/pages/cart/cart.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 当用户点击加入购物车，首先判断购物车中的购物项的数量是否<库存
	 * <p>
	 * 如果满足就可以购买
	 * <p>
	 * 如果不满足就不可以购买
	 * 
	 * @param request
	 * @param response
	 */
	public void booleanAdd(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		// 如果购物车为空，就证明没有买过，购物项的数量也为0
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (cart == null) {
			// 购物车为空,可以购买
			writer.print("1");
		} else {
			// 购物车不为空，查看有没有该购物项
			Map<String, CartItem> map = cart.getMap();
			CartItem cartItem = map.get(id);
			if (cartItem == null) {
				// 没有该购物项，不需要判断
				writer.print("1");
			} else {
				// 有该购物项，判断是否可以购买
				Integer count = cartItem.getCount();
				int stock = cartItem.getBook().getStock();
				if (count < stock) {
					// 购物车中购物项的数量<库存：可以购买
					writer.print("1");
				} else {
					// 不能购买
					writer.print("0");
				}
			}
		}
	}

	/**
	 * 当用户点击加入购物车，判断可以购买的时候,进入此方法
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addCartItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Book book = bookService.getBook(id);
		// 创建购物项
		CartItem cartItem = new CartItem(book, 1, 0);
		// 首先从session中获取购物车
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");

		// 判断购物车是否为空
		if (cart == null) {
			// 创建购物车
			Map<String, CartItem> map = new LinkedHashMap<>();
			map.put(id, cartItem);
			session.setAttribute("cart", new Cart(map, 0, 0));
		} else {
			// 如果不是第一次添加购物项，那么购物车存在
			Map<String, CartItem> map = cart.getMap();
			// 判断map中是否有该图书的购物项
			Set<String> keySet = map.keySet();
			// 判断是否存在该图书的标识
			boolean flag = true;
			// 遍历购物车中的所有购物项
			for (String string : keySet) {
				// 如果购物项的id与图书的id相同，那么只需要修改该购物项的数量即可
				if (string.equals(id)) {
					CartItem cartItem2 = map.get(string);
					cartItem2.setCount(cartItem2.getCount() + 1);
					// 修改标识
					flag = false;
				}
			}
			// 购物车中没有该图书的购物项
			if (flag) {
				map.put(id, cartItem);
			}
		}
		// ?methodName=getPageBooks&pageNo=
		String pageNo = request.getParameter("pageNo");
		response.sendRedirect(request.getContextPath() + "/BookServlet?methodName=getPageBooks&pageNo=" + pageNo);
	}
}
