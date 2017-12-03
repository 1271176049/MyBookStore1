package edu.sdp.com.manager.dao.impl;

import java.util.List;

import edu.sdp.com.beans.Book;
import edu.sdp.com.client.dao.BaseDao;
import edu.sdp.com.manager.dao.ManagerBookDao;

public class ManagerBookDaoImpl extends BaseDao<Book> implements ManagerBookDao {

	@Override
	public List<Book> getBooks() {
		// id | title | author | price | sales | stock | img_path
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from books";
		return getBeanList(sql);
	}

	@Override
	public void saveBook(Book book) {
		// 保存
		String sql = "insert into books(title,price,author,sales,stock) values(?,?,?,?,?)";
		update(sql, book.getTitle(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock());
	}

	@Override
	public Book getBook(String id) {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from books where id=?";
		// 获取单个对象
		return getBean(sql, id);
	}

	@Override
	public void editBook(Book book) {
		// 修改
		String sql = "update books set title=?,price=?,author=?,sales=?,stock=? where id=?";
		update(sql, book.getTitle(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getId());
	}

	@Override
	public void deleteBook(String id) {
		String sql = "delete from books where id=?";
		update(sql, id);

	}

}
