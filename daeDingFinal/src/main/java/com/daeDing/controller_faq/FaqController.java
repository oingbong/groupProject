package com.daeDing.controller_faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.FaqDao;

@Controller
public class FaqController {
	@Autowired
	private FaqDao dao;
	
	public void setDao(FaqDao dao) {
		this.dao = dao;
	}

	// Faq 목록
	@RequestMapping("/member/listFaq.do")
	public ModelAndView form(){
		ModelAndView view = new ModelAndView();
		//view.addObject("a", dao.detail(a_no));
		view.addObject("list", dao.list());
		view.addObject("viewPage", "member/listFaq.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	// Faq 상세보기
	@RequestMapping("/member/detailFaq.do")
	public ModelAndView detail(int f_no){
		ModelAndView view = new ModelAndView();
		view.addObject("f", dao.detail(f_no));
		view.addObject("viewPage", "member/detailFaq.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	// Faq 삭제하기
	@RequestMapping("/member/deleteFaq.do")
	public ModelAndView delete(int f_no){
		ModelAndView view = new ModelAndView();
		view.addObject("f", dao.delete(f_no));
		view.addObject("viewPage", "member/listFaq.jsp");
		view.setViewName("redirect:/member/listFaq.do");
		
		return view;
	}
}
