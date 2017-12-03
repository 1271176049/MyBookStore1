package edu.sdp.com.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 购物车:
 * <p>
 * -用户的id,先不考虑
 * <p>
 * -购物项集合Map<String,购物项> 因为在做购物车中图书的数量修改的时候，我们要根据图书的id，来找到购物项
 * <p>
 * -总商品数量 :根据计算得到
 * <p>
 * -总金额:根据计算得到
 * 
 * @author 王大锤
 *
 */
public class Cart {
	private Map<String, CartItem> map = new LinkedHashMap<>();
	private Integer totalCount;
	private double totalAmount;

	public Cart() {
		super();
	}

	public Cart(Map<String, CartItem> map, Integer totalCount, double totalAmount) {
		super();
		this.map = map;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	public Integer getTotalCount() {
		totalCount = 0;
		Collection<CartItem> cartItems = map.values();
		for (CartItem cartItem : cartItems) {
			totalCount += cartItem.getCount();
		}
		return totalCount;
	}

	/*
	 * public void setTotalCount(Integer totalCount) { this.totalCount =
	 * totalCount; }
	 */
	// 通过购物项的总金额相加得到购物车的总金额
	public double getTotalAmount() {
		BigDecimal t=new BigDecimal("0");
		Collection<CartItem> cartItems = map.values();
		for (CartItem cartItem : cartItems) {
			t=t.add(new BigDecimal(cartItem.getAmount()+""));
		}
		return t.doubleValue();
	}

	/*
	 * public void setTotalAmount(double totalAmount) { this.totalAmount =
	 * totalAmount; }
	 */
	/**
	 * 购物车界面jstl遍历的时候不能直接遍历map集合，遍历list更方便
	 * 
	 * @return
	 */
	public ArrayList<CartItem> getCartItemList() {
		Collection<CartItem> values = map.values();
		values.forEach(System.out::println);
		return new ArrayList<>(values);

	}

	@Override
	public String toString() {
		return "Cart [map=" + map + ", totalCount=" + totalCount + ", totalAmount=" + totalAmount + "]";
	}

	public void clear() {
		map.clear();
	}

}
