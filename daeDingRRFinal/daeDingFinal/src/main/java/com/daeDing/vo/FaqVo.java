package com.daeDing.vo;

public class FaqVo {
	private int f_no;
	private String f_title;
	private String f_content;
	
	public FaqVo(int f_no, String f_title, String f_content) {
		super();
		this.f_no = f_no;
		this.f_title = f_title;
		this.f_content = f_content;
	}

	public FaqVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public String getF_title() {
		return f_title;
	}

	public void setF_title(String f_title) {
		this.f_title = f_title;
	}

	public String getF_content() {
		return f_content;
	}

	public void setF_content(String f_content) {
		this.f_content = f_content;
	}
	
	
}
