package edu.sdp.com.client.dao.impl;

import java.util.List;

import edu.sdp.com.beans.Book;
import edu.sdp.com.beans.Page;
import edu.sdp.com.client.dao.BaseDao;
import edu.sdp.com.client.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getBooks() {
		// id | title | author | price | sales | stock | img_path
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from books";
		return getBeanList(sql);
	}

	/**
	 * 执行两条sql语句
	 */
	@Override
	public Page<Book> getPageBooks(Page<Book> page) {

		// 获取总的记录数
		String sql1 = "select count(*) from books";
		long totalRecord = (long) getSingleValue(sql1);
		// 获取当前页的数据
		String sql2 = "select id,title,author,price,sales,stock,img_path imgPath from books limit ?,?";
		int pageNo = page.getPageNo();
		System.out.println("pageNo" + pageNo);
		System.out.println((pageNo - 1) * Page.PAGE_SIZE);
		List<Book> beanList = getBeanList(sql2, (pageNo - 1) * Page.PAGE_SIZE, Page.PAGE_SIZE);
		page.setList(beanList);
		page.setTotalRecord((int) totalRecord);
		return page;
	}

	@Override
	public Book getBook(String id) {
		String sql = "select id,title,author,price,sales,stock from books where id=?";
		Book bean = getBean(sql, id);
		return bean;
	}

	@Override
	public void updateBook(Object[][] objects2) {
		String sql = "update books set sales=?,stock=? where id=?";
		batch(sql, objects2);
	}

}
