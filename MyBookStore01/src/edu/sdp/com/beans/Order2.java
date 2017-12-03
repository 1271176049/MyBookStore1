package edu.sdp.com.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 封装订单信息的类
 * 
 * @author HanYanBing
 *
 */
public class Order2 {

	private String id; // 订单号
	private Date orderTime; // 生成订单的时间
	private int totalCount; // 商品总数量
	private double totalAmount; // 商品总金额
	private int state; // 订单状态 0：未发货 1：已发货 2：交易完成
	private int userId; // 订单所属的用户
	private User user;
	private ArrayList<OrderItem> orderItems;

	public Order2() {
		super();
	}

	public Order2(String id, Date orderTime, int totalCount, double totalAmount, int state, int userId, User user,
			ArrayList<OrderItem> orderItems) {
		super();
		this.id = id;
		this.orderTime = orderTime;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.state = state;
		this.userId = userId;
		this.user = user;
		this.orderItems = orderItems;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderTime() {
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sf2.format(orderTime);
		return format;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(ArrayList<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order2 [id=" + id + ", orderTime=" + orderTime + ", totalCount=" + totalCount + ", totalAmount="
				+ totalAmount + ", state=" + state + ", userId=" + userId + ", user=" + user + ", orderItems="
				+ orderItems + "]";
	}

}
