package edu.sdp.com.manager.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sdp.com.beans.User;

public class ManagerLoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
		// 判断用户是否登陆
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		// 如果用户等于null,那么没有登陆，让用户登陆
		if (user == null) {
			request.setAttribute("msg", "需要管理员登陆才能访问");
			try {
				request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// 如果登陆了，判断是不是管理员
			if ("admin".equals(user.getUsername())) {
				// 如果时管理员就放行
				try {
					chain.doFilter(request, response);
				} catch (IOException | ServletException e) {
					e.printStackTrace();
				}
			} else {
				// 如果不是管理员就让用户重新登陆
				request.setAttribute("msg", "权限不足，请用户管理员身份登陆");
				try {
					request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
