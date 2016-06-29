package com.daeDing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/member/index.do")
	public ModelAndView form(){
		ModelAndView view = new ModelAndView();
		view.addObject("viewPage", "member/index.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	@RequestMapping("/member/contactUs.do")
	public ModelAndView contactUs(){
		ModelAndView view = new ModelAndView();
		view.addObject("viewPage", "member/contactUs.jsp");
		view.setViewName("templateE");
		return view;
	}
}
