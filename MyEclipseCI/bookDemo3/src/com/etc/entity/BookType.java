package com.etc.entity;

public class BookType {
   // Ù–‘
 private int typeid;
 private String typename;
 
 
 public BookType(int typeid, String typename) {
  super();
  this.typeid = typeid;
  this.typename = typename;
 }
 public BookType() {
  super();
 }
 public int getTypeid() {
  return typeid;
 }
 public void setTypeid(int typeid) {
  this.typeid = typeid;
 }
 public String getTypename() {
  return typename;
 }
 public void setTypename(String typename) {
  this.typename = typename;
 }
 @Override
 public String toString() {
  return "BookType [typeid=" + typeid + ", typename=" + typename + "]";
 }
 
 
}