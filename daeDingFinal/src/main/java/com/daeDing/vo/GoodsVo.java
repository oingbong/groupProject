package com.daeDing.vo;

import org.springframework.web.multipart.MultipartFile;

public class GoodsVo {
	
	private int g_no;
	private String g_name;
	private int g_price;
	private int g_saleprice;
	private int g_delivery;
	private String g_companyname;
	private String g_img;
	private String g_type;
	private MultipartFile g_uploadimg;
	
	
	public MultipartFile getG_uploadimg() {
		return g_uploadimg;
	}
	public void setG_uploadimg(MultipartFile g_uploadimg) {
		this.g_uploadimg = g_uploadimg;
	}
	public GoodsVo(int g_no, String g_name, int g_price, int g_saleprice, int g_delivery, String g_companyname,
			String g_img, String g_type, MultipartFile g_uploadimg) {
		super();
		this.g_no = g_no;
		this.g_name = g_name;
		this.g_price = g_price;
		this.g_saleprice = g_saleprice;
		this.g_delivery = g_delivery;
		this.g_companyname = g_companyname;
		this.g_img = g_img;
		this.g_type = g_type;
		this.g_uploadimg = g_uploadimg;
	}
	public GoodsVo(int g_no, String g_name, int g_price, int g_saleprice, int g_delivery, String g_companyname,
			String g_img, String g_type) {
		super();
		this.g_no = g_no;
		this.g_name = g_name;
		this.g_price = g_price;
		this.g_saleprice = g_saleprice;
		this.g_delivery = g_delivery;
		this.g_companyname = g_companyname;
		this.g_img = g_img;
		this.g_type = g_type;
	}
	public GoodsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public int getG_price() {
		return g_price;
	}
	public void setG_price(int g_price) {
		this.g_price = g_price;
	}
	public int getG_saleprice() {
		return g_saleprice;
	}
	public void setG_saleprice(int g_saleprice) {
		this.g_saleprice = g_saleprice;
	}
	public int getG_delivery() {
		return g_delivery;
	}
	public void setG_delivery(int g_delivery) {
		this.g_delivery = g_delivery;
	}
	public String getG_companyname() {
		return g_companyname;
	}
	public void setG_companyname(String g_companyname) {
		this.g_companyname = g_companyname;
	}
	public String getG_img() {
		return g_img;
	}
	public void setG_img(String g_img) {
		this.g_img = g_img;
	}
	public String getG_type() {
		return g_type;
	}
	public void setG_type(String g_type) {
		this.g_type = g_type;
	}
	
	
}
