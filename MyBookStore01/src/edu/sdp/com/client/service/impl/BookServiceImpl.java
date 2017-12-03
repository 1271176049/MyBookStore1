package edu.sdp.com.client.service.impl;

import java.util.List;

import edu.sdp.com.beans.Book;
import edu.sdp.com.beans.Page;
import edu.sdp.com.client.dao.BookDao;
import edu.sdp.com.client.dao.impl.BookDaoImpl;
import edu.sdp.com.client.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();

	@Override
	public List<Book> getBooks() {
		return bookDao.getBooks();
	}

	@Override
	public Page<Book> getPageBooks(String pageNo) {
		int defaultPageNo = 1;
		try {
			defaultPageNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
			// e.printStackTrace();
		}
		Page<Book> page = new Page<>();
		page.setPageNo(defaultPageNo);
		System.out.println(page);
		return bookDao.getPageBooks(page);
	}

	@Override
	public Book getBook(String id) {
		
		return bookDao.getBook(id);
	}

}
