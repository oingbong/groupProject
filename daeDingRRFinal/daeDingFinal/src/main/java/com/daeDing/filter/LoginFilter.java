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
		//로그인 여부를 파악하여 로그인 하지 않은 회원이면 login.do를 요청하도록 한다.
		String m_id = (String)(((HttpServletRequest)request).getSession()).getAttribute("m_id");
		if(m_id==null){
			(((HttpServletRequest)request).getSession()).setAttribute("msg", "로그인 하고 사용하시기 바랍니다");
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
