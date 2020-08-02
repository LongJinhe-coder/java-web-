package com.etc.entity;

public class Book1 {
	
	private int bid;
	private String bookname;
	private String booktype;
	public Book1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book1(int bid, String bookname, String booktype) {
		super();
		this.bid = bid;
		this.bookname = bookname;
		this.booktype = booktype;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	@Override
	public String toString() {
		return "Book1 [bid=" + bid + ", bookname=" + bookname + ", booktype=" + booktype + "]";
	}
	
	
}
