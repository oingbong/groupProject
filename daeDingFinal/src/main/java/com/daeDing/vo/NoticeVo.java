package com.daeDing.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class NoticeVo {
	private int n_no;
	private String n_title;
	private String n_writer;
	private String n_content;
	private int n_hit;
	private Date n_date;
	private String n_pwd;
	private String n_fname;
	private int n_fsize;
	private int b_ref;
	private int b_level;
	private int b_step;
	private int del_p;
	
	private MultipartFile uploadFile;
	
	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public NoticeVo(int n_no, String n_title, String n_writer, String n_content, int n_hit, Date n_date, String n_pwd,
			String n_fname, int n_fsize, int b_ref, int b_level, int b_step, int del_p, MultipartFile uploadFile) {
		super();
		this.n_no = n_no;
		this.n_title = n_title;
		this.n_writer = n_writer;
		this.n_content = n_content;
		this.n_hit = n_hit;
		this.n_date = n_date;
		this.n_pwd = n_pwd;
		this.n_fname = n_fname;
		this.n_fsize = n_fsize;
		this.b_ref = b_ref;
		this.b_level = b_level;
		this.b_step = b_step;
		this.del_p = del_p;
		this.uploadFile = uploadFile;
	}

	public NoticeVo(int n_no, String n_title, String n_writer, String n_content, int n_hit, Date n_date, String n_pwd,
			String n_fname, int n_fsize, int b_ref, int b_level, int b_step, int del_p) {
		super();
		this.n_no = n_no;
		this.n_title = n_title;
		this.n_writer = n_writer;
		this.n_content = n_content;
		this.n_hit = n_hit;
		this.n_date = n_date;
		this.n_pwd = n_pwd;
		this.n_fname = n_fname;
		this.n_fsize = n_fsize;
		this.b_ref = b_ref;
		this.b_level = b_level;
		this.b_step = b_step;
		this.del_p = del_p;
	}

	public NoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_writer() {
		return n_writer;
	}

	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public int getN_hit() {
		return n_hit;
	}

	public void setN_hit(int n_hit) {
		this.n_hit = n_hit;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}

	public String getN_pwd() {
		return n_pwd;
	}

	public void setN_pwd(String n_pwd) {
		this.n_pwd = n_pwd;
	}

	public String getN_fname() {
		return n_fname;
	}

	public void setN_fname(String n_fname) {
		this.n_fname = n_fname;
	}

	public int getN_fsize() {
		return n_fsize;
	}

	public void setN_fsize(int n_fsize) {
		this.n_fsize = n_fsize;
	}

	public int getB_ref() {
		return b_ref;
	}

	public void setB_ref(int b_ref) {
		this.b_ref = b_ref;
	}

	public int getB_level() {
		return b_level;
	}

	public void setB_level(int b_level) {
		this.b_level = b_level;
	}

	public int getB_step() {
		return b_step;
	}

	public void setB_step(int b_step) {
		this.b_step = b_step;
	}

	public int getDel_p() {
		return del_p;
	}

	public void setDel_p(int del_p) {
		this.del_p = del_p;
	}
	
	
	
	
}
