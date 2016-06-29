package com.daeDing.vo;

import java.util.Date;

public class OrderInfoVo {

	private int oi_no;
	private Date oi_date;
	private int oi_price;
	private String oi_id;
	private int oi_buycount;
	private int oi_goodsno;
	
	public OrderInfoVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderInfoVo(int oi_no, Date oi_date, int oi_price, String oi_id, int oi_buycount, int oi_goodsno) {
		super();
		this.oi_no = oi_no;
		this.oi_date = oi_date;
		this.oi_price = oi_price;
		this.oi_id = oi_id;
		this.oi_buycount = oi_buycount;
		this.oi_goodsno = oi_goodsno;
	}

	public int getOi_no() {
		return oi_no;
	}

	public void setOi_no(int oi_no) {
		this.oi_no = oi_no;
	}

	public Date getOi_date() {
		return oi_date;
	}

	public void setOi_date(Date oi_date) {
		this.oi_date = oi_date;
	}

	public int getOi_price() {
		return oi_price;
	}

	public void setOi_price(int oi_price) {
		this.oi_price = oi_price;
	}

	public String getOi_id() {
		return oi_id;
	}

	public void setOi_id(String oi_id) {
		this.oi_id = oi_id;
	}

	public int getOi_buycount() {
		return oi_buycount;
	}

	public void setOi_buycount(int oi_buycount) {
		this.oi_buycount = oi_buycount;
	}

	public int getOi_goodsno() {
		return oi_goodsno;
	}

	public void setOi_goodsno(int oi_goodsno) {
		this.oi_goodsno = oi_goodsno;
	}

	
	
	
}
