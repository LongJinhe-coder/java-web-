package com.etc.entity;

public class Book {
 //属性
 private int bid;
 private String bookname;
 //新增成员变量 bt
 private BookType bt;
 
 public Book() {
  super();
 }
 public Book(int bid, String bookname, BookType bt) {
  super();
  this.bid = bid;
  this.bookname = bookname;
  this.bt = bt;
 }
 
 public Book(int bid, String bookname) {
  super();
  this.bid = bid;
  this.bookname = bookname;
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

 @Override
 public String toString() {
  return "Book [bid=" + bid + ", bookname=" + bookname + ", bt=" + bt + "]";
 }
 public void setBookname(String bookname) {
  this.bookname = bookname;
 }
 public BookType getBt() {
  return bt;
 }
 public void setBt(BookType bt) {
  this.bt = bt;
 }
 

}