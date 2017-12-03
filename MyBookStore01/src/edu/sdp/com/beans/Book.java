package edu.sdp.com.beans;

/**
 * 图书实体类
 * 
 * @author 王大锤
 *         <p>
 *         private Integer id;图书id
 *         <p>
 *         private String title;书名
 *         <p>
 *         private String author;作者
 *         <p>
 *         private double price;价格
 *         <p>
 *         private int sales;销量
 *         <p>
 *         private int stock;库存
 *         <p>
 *         private String imgPath;图片路径
 */
public class Book {
	// | id | title | author | price | sales | stock | img_path |
	private Integer id;
	private String title;
	private String author;
	private double price;
	private int sales;
	private int stock;
	private String imgPath="/static/img/default.jpg";// 与数据库中的字段不同，注意起别名

	public Book() {
		super();
	}

	public Book(Integer id, String title, String author, double price, int sales, int stock, String imgPath) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		this.imgPath = imgPath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", sales=" + sales
				+ ", stock=" + stock + ", imgPath=" + imgPath + "]";
	}

}
