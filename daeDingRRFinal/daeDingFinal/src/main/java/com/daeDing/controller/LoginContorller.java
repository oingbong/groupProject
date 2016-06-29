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
@RequestMapping("/login.do")
public class LoginContorller {
	@Autowired
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(){
		ModelAndView view = new ModelAndView();
		view.addObject("viewPage", "login.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(String m_id, String m_pwd, HttpSession session){
		ModelAndView view = new ModelAndView();
		MemberVo m = dao.isMember(m_id, m_pwd);
		if(m != null){
			session.setAttribute("m_id", m_id);
			session.setAttribute("m_type", dao.detail(m_id).getM_type());
			//view.setViewName("member/index");
			//view.setViewName("redirect:/member/listMember.do");
			view.setViewName("redirect:/member/index.do");
		}else{
			view.addObject("msg", "´Ù½ÃÇØºÁ");
			view.setViewName("redirect:/login.do");
		}
		return view;
	}
}
