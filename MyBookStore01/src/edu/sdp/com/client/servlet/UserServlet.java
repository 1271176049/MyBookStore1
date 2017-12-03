package edu.sdp.com.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.sdp.com.beans.User;
import edu.sdp.com.client.service.UserService;
import edu.sdp.com.client.service.impl.UserServiceImpl;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * 用户和管理员登陆
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 如果有该用户则为true
		User user = userService.login(username, password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// 重定向到界面
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		} else {
			request.setAttribute("msg", "登陆失败，用户或密码不正确");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}

	/**
	 * 前端使用Ajax判断用户名是否存在
	 */
	public void registName(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入判断用户名是否存在的方法");
		String username = request.getParameter("username");
		// 如果该用户存在就为true
		boolean flag = userService.getUserByName(username);
		if (flag) {
			// 该用户存在
			try {
				response.getWriter().println("用户名已存在");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

		}
	}

}
