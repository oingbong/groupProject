package com.daeDing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.MemberDao;
import com.daeDing.vo.MemberVo;

@Controller
@RequestMapping("/logout.do")
public class LogoutContorller {
	@Autowired
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(HttpSession session){
		ModelAndView view = new ModelAndView();
		System.out.println("로그아웃왔어용");
		session.setAttribute("m_id", null);
		session.setAttribute("m_type", 9);
		
		System.out.println(session.getAttribute("m_id")+"로그아웃 아이디");
		view.setViewName("redirect:/member/listGoods.do");
		return view;
	}
	
	
}
