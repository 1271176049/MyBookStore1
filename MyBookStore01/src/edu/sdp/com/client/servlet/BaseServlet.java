package edu.sdp.com.client.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现利用反射机制，根据方法名来执行对应的方法
 * 
 * @author 王大锤
 *
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BaseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 在第一次请求中设置
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");

		String methodName = request.getParameter("methodName");
		System.out.println("进入BaseServlet,方法名为" + methodName);
		// 利用反射机制获取对应的方法
		try {
			Method declaredMethod = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 对该方法进行爆破
			declaredMethod.setAccessible(true);
			// 执行该方法
			declaredMethod.invoke(this, request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
