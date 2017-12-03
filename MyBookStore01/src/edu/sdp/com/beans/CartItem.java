package edu.sdp.com.beans;

import java.math.BigDecimal;

/**
 * 购物项： -书名 -数量 -单价 -金额:根据计算得到
 * 
 * @author 王大锤
 *
 */
public class CartItem {
	private Book book;
	private Integer count;
//	private double amount;

	public CartItem() {
		super();
	}

	public CartItem(Book book, Integer count, double amount) {
		super();
		this.book = book;
		this.count = count;
//		this.amount = amount;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	// 根据图书的单价和数量得到
	public double getAmount() {
		BigDecimal price1 = new BigDecimal(book.getPrice()+"");
		BigDecimal count1 = new BigDecimal(getCount() + "");
		return price1.multiply(count1).doubleValue();
	}

	/*
	 * public void setAmount(double amount) { this.amount = amount; }
	 */

	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", amount=" + getCount() + "]";
	}

}
