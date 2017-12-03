package edu.sdp.com.client.dao;

import java.util.List;

import edu.sdp.com.beans.Book;
import edu.sdp.com.beans.Page;

/**
 * 处理图书的增删改查
 * @author 王大锤
 *
 */
public interface BookDao {

	List<Book> getBooks();

	Page<Book> getPageBooks(Page<Book> page);

	Book getBook(String id);

	void updateBook(Object[][] objects2);

}
