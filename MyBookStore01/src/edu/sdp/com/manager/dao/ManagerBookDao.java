package edu.sdp.com.manager.dao;

import java.util.List;

import edu.sdp.com.beans.Book;

public interface ManagerBookDao {

	List<Book> getBooks();

	void saveBook(Book book);

	Book getBook(String id);

	void editBook(Book book);

	void deleteBook(String id);

}
