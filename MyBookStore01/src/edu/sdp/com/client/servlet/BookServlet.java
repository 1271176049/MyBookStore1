package edu.sdp.com.client.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdp.com.beans.Book;
import edu.sdp.com.beans.Page;
import edu.sdp.com.client.service.BookService;
import edu.sdp.com.client.service.impl.BookServiceImpl;

/**
 * 处理图书的Servlet
 */
public class BookServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookServiceImpl();

	/**
	 * 获取所有的图书
	 * 
	 * @param request
	 * @param response
	 */
	protected void getBooks(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入到BookServlet的getBooks方法");
		List<Book> list = bookService.getBooks();
		list.forEach(System.out::println);
		// 将list集合存放到request域中
		request.setAttribute("list", list);
		// 转发到界面
		try {
			request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取分页类
	 * <p>
	 * 该类中含有要查询当前页的List<Book>
	 * 
	 * @param request
	 * @param response
	 */
	protected void getPageBooks(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("进入到BookServlet的getPageBooks方法");
		// 获取要查询的页
		String pageNo = request.getParameter("pageNo");
		 Page<Book> pageBooks = bookService.getPageBooks(pageNo);
		// 将Page存放到request域中
		request.setAttribute("page", pageBooks);
		// 转发到界面
		try {
			request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
