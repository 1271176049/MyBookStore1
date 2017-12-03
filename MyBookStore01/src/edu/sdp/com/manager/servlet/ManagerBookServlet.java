package edu.sdp.com.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sdp.com.beans.Book;
import edu.sdp.com.client.servlet.BaseServlet;
import edu.sdp.com.manager.service.ManagerBookService;
import edu.sdp.com.manager.service.impl.ManagerBookServiceImpl;

public class ManagerBookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private ManagerBookService bookService = new ManagerBookServiceImpl();

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
			request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加图书的方法
	 * 
	 * @param request
	 * @param response
	 */
	public void addBook(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String author = request.getParameter("author");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		/*
		 * private double price; private int sales; private int stock;
		 */
		Book book = new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales),
				Integer.parseInt(stock), null);
		bookService.saveBook(book);
		getBooks(request, response);
	}

	/**
	 * 修改图书的方法
	 * 
	 */
	public void editBook(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String price = request.getParameter("price");
		String author = request.getParameter("author");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		String id = request.getParameter("id");
		Book book = new Book(Integer.valueOf(id), title, author, Double.parseDouble(price), Integer.parseInt(sales),
				Integer.parseInt(stock), null);
		bookService.editBook(book);
		getBooks(request, response);
	}

	/**
	 * 获取一个图书信息
	 * <p>
	 * 进入修改图书界面的方法
	 * 
	 * @param request
	 * @param response
	 */
	public void getBook(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Book book = bookService.getBook(id);
		request.setAttribute("book", book);
		try {
			request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除图书的方法
	 */
	public void deleteBook(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		bookService.deleteBook(id);
		getBooks(request, response);
	}
}
