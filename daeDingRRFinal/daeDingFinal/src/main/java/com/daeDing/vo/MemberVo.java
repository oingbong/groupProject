package com.daeDing.vo;

import java.util.Date;

public class MemberVo {
	
	private String m_id;
	private int m_type;
	private String m_name;
	private String m_pwd;
	private Date m_birth;
	private String m_gender;
	private String m_addr;
	private String m_phone;
	private String m_email;
	
	public MemberVo(String m_id, int m_type, String m_name, String m_pwd, Date m_birth, String m_gender, String m_addr,
			String m_phone, String m_email) {
		super();
		this.m_id = m_id;
		this.m_type = m_type;
		this.m_name = m_name;
		this.m_pwd = m_pwd;
		this.m_birth = m_birth;
		this.m_gender = m_gender;
		this.m_addr = m_addr;
		this.m_phone = m_phone;
		this.m_email = m_email;
	}

	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getM_type() {
		return m_type;
	}

	public void setM_type(int m_type) {
		this.m_type = m_type;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}

	public Date getM_birth() {
		return m_birth;
	}

	public void setM_birth(Date m_birth) {
		this.m_birth = m_birth;
	}

	public String getM_gender() {
		return m_gender;
	}

	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	
	
}
