package com.daeDing.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//�α��� ���θ� �ľ��Ͽ� �α��� ���� ���� ȸ���̸� login.do�� ��û�ϵ��� �Ѵ�.
		String m_id = (String)(((HttpServletRequest)request).getSession()).getAttribute("m_id");
		if(m_id==null){
			(((HttpServletRequest)request).getSession()).setAttribute("msg", "�α��� �ϰ� ����Ͻñ� �ٶ��ϴ�");
			((HttpServletResponse)response).sendRedirect("/home/login.do");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
