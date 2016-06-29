package com.daeDing.vo;

import java.util.Date;

public class QuestionVo {
	private int q_no;
	private String q_type;
	private Date q_date;
	private int q_pwd;
	private String q_title;
	private String q_id;
	private String q_content;
	private String q_yesNo;
	
	public QuestionVo(int q_no, String q_type, Date q_date, int q_pwd, String q_title, String q_id, String q_content,
			String q_yesNo) {
		super();
		this.q_no = q_no;
		this.q_type = q_type;
		this.q_date = q_date;
		this.q_pwd = q_pwd;
		this.q_title = q_title;
		this.q_id = q_id;
		this.q_content = q_content;
		this.q_yesNo = q_yesNo;
	}

	public QuestionVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQ_no() {
		return q_no;
	}

	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}

	public String getQ_type() {
		return q_type;
	}

	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}

	public Date getQ_date() {
		return q_date;
	}

	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}

	public int getQ_pwd() {
		return q_pwd;
	}

	public void setQ_pwd(int q_pwd) {
		this.q_pwd = q_pwd;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_id() {
		return q_id;
	}

	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public String getQ_yesNo() {
		return q_yesNo;
	}

	public void setQ_yesNo(String q_yesNo) {
		this.q_yesNo = q_yesNo;
	}
	
}
