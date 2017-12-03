package edu.sdp.com.client.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sdp.com.beans.User;
import edu.sdp.com.manager.filter.HttpFilter;

public class OrderFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		// 拦截用户结算购物车时未登录
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		//
		if (user == null) {
			// 到登陆界面，提示用户登陆
			request.setAttribute("msg", "结算购物车需要登陆");
			try {
				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				chain.doFilter(request, response);
			} catch (IOException | ServletException e) {
				e.printStackTrace();
			}
		}

	}

}
