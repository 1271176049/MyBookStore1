package edu.sdp.com.client.service;

import java.util.List;

import edu.sdp.com.beans.Book;
import edu.sdp.com.beans.Page;

/**
 * 处理图书的业务
 * 
 * @author 王大锤
 *
 */
public interface BookService {
	/**
	 * 获取所有的图书信息
	 * 
	 * @return
	 */
	List<Book> getBooks();

	/**
	 * 获取当前页的图书信息
	 * 
	 * @param pageNo
	 * @return
	 */
	Page<Book> getPageBooks(String pageNo);

	Book getBook(String id);

}
