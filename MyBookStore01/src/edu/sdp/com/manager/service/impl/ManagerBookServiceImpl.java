package edu.sdp.com.manager.service.impl;

import java.util.List;

import edu.sdp.com.beans.Book;
import edu.sdp.com.manager.dao.ManagerBookDao;
import edu.sdp.com.manager.dao.impl.ManagerBookDaoImpl;
import edu.sdp.com.manager.service.ManagerBookService;

public class ManagerBookServiceImpl implements ManagerBookService {
private ManagerBookDao bookDao=new ManagerBookDaoImpl();
	@Override
	public List<Book> getBooks() {
		
		return bookDao.getBooks();
	}
	@Override
	public void saveBook(Book book) {
		bookDao.saveBook(book);
		
	}
	@Override
	public Book getBook(String id) {
		
		return bookDao.getBook(id);
	}
	@Override
	public void editBook(Book book) {
		bookDao.editBook(book);
	}
	@Override
	public void deleteBook(String id) {
		bookDao.deleteBook(id);
		
	}

}
