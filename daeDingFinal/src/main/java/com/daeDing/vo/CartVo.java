package com.daeDing.vo;

public class CartVo {
	private int c_no;
	private String c_id;
	private int c_goodsno;
	private int c_goodscnt;
	private int c_goodsprice;
	public CartVo(int c_no, String c_id, int c_goodsno, int c_goodscnt, int c_goodsprice) {
		super();
		this.c_no = c_no;
		this.c_id = c_id;
		this.c_goodsno = c_goodsno;
		this.c_goodscnt = c_goodscnt;
		this.c_goodsprice = c_goodsprice;
	}
	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public int getC_goodsno() {
		return c_goodsno;
	}
	public void setC_goodsno(int c_goodsno) {
		this.c_goodsno = c_goodsno;
	}
	public int getC_goodscnt() {
		return c_goodscnt;
	}
	public void setC_goodscnt(int c_goodscnt) {
		this.c_goodscnt = c_goodscnt;
	}
	public int getC_goodsprice() {
		return c_goodsprice;
	}
	public void setC_goodsprice(int c_goodsprice) {
		this.c_goodsprice = c_goodsprice;
	}
	
	
}
