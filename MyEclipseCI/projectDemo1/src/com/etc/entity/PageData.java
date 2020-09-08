package com.etc.entity;

import java.util.List;

public class PageData {
	
	private List data;
	private Integer pageNo;//当前页面
	private Integer pageSize;//页面记录数大小
	private Integer totalCount;//总记录条数
	private Integer totalPage;//总页数大小
	public PageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageData(List data, Integer pageNo, Integer pageSize, Integer totalCount) {
		super();
		this.data = data;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		if (pageSize>0) {//避免模糊查询时除0事件
			this.totalPage = totalCount%pageSize==0? totalCount/pageSize : (totalCount/pageSize)+1;
		}else {
			this.totalPage = 0;
		}
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	@Override
	public String toString() {
		return "PageData [data=" + data + ", pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + "]";
	}
	
	
}
