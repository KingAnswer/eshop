package com.qingshixun.project.eshop.module.order.util;

import java.util.List;


public class PagUtil<t> {
	
	private int pageNo;
	private int pageTotal;
	private List<t> data;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public List<t> getData() {
		return data;
	}
	public void setData(List<t> data) {
		this.data = data;
	}


}
