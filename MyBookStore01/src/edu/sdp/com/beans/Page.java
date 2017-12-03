package edu.sdp.com.beans;

import java.util.List;

/**
 * Page<T>页面类
 * 
 * @author 王大锤
 *
 * @param <T>
 */
public class Page<T> {

	private int pageNo;// 当前页
	private int totalPageNo;// 总页数，计算可得
	private int totalRecord;// 总记录数，查询可得
	public static final int PAGE_SIZE = 4;// 每页显示多少条记录，固定
	private List<T> list;// 从数据库中查询的记录

	public Page() {
		super();
	}

	public Page(int pageNo, int totalPageNo, int totalRecord, List<T> list) {
		super();
		this.totalPageNo = totalPageNo;
		this.totalRecord = totalRecord;
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 总页数通过计算得到，set方法不需要
	 * 
	 * @return
	 */
	public int getTotalPageNo() {
		totalPageNo = getTotalRecord() / PAGE_SIZE;
		return totalPageNo;
	}

	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	// 判断是否是第一页
	public boolean getPrev() {
		return pageNo > 1;
	}

	// 判断是否是最后一页
	public boolean getNext() {
		return pageNo < getTotalPageNo();
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", totalPageNo=" + totalPageNo + ", totalRecord=" + totalRecord + ", list="
				+ list + "]";
	}

}
