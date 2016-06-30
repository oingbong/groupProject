package com.daeDing.controller_faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.FaqDao;
import com.daeDing.vo.FaqVo;

@Controller
@RequestMapping("/member/insertFaq.do")
public class InsertFaqController {
	@Autowired
	private FaqDao dao;

	public void setDao(FaqDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(){
		ModelAndView view = new ModelAndView();
		view.addObject("viewPage","member/insertFaq.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(FaqVo f){
		ModelAndView view = new ModelAndView();
		int re = dao.insert(f);
		if(re==1){
			view.setViewName("redirect:/member/listFaq.do");
		}else{
			view.addObject("msg", "Q&A 추가를 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}
		return view;
	}
}
