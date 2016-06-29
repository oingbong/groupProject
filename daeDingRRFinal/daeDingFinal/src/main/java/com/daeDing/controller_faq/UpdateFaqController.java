package com.daeDing.controller_faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.FaqDao;
import com.daeDing.vo.FaqVo;

@Controller
@RequestMapping("/member/updateFaq.do")
public class UpdateFaqController {
	
	@Autowired
	private FaqDao dao;

	public void setDao(FaqDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(int f_no){
		ModelAndView view = new ModelAndView();
		FaqVo f = dao.detail(f_no);
		view.addObject("f", f);
		view.addObject("viewPage", "member/updateFaq.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(FaqVo f){
		ModelAndView view = new ModelAndView();
		int re = dao.update(f);
		if(re >= 1){
			view.setViewName("redirect:/member/listFaq.do");
		}else{
			view.addObject("msg", "회원정보 수정에 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
		}
		return view;
	}
}
