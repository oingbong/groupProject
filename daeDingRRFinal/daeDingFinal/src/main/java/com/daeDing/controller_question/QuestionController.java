package com.daeDing.controller_question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.MemberDao;
import com.daeDing.dao.QuestionDao;

@Controller
public class QuestionController {

	@Autowired
	private QuestionDao dao;

	public void setDao(QuestionDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	private MemberDao dao2;
	
	public void setDao2(MemberDao dao2) {
		this.dao2 = dao2;
	}


	// 문의 사항 목록
	@RequestMapping("/member/listQuestion.do")
	public ModelAndView list(){
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("list", dao.list());
		view.addObject("viewPage", "member/listQuestion.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/listQuestion");
		
		return view;
	}
	
	// 문의 사항 정보
	@RequestMapping("/member/detailQuestion.do")
	public ModelAndView detail(int q_no){
		ModelAndView view = new ModelAndView();
		
		String id = dao.detail(q_no).getQ_id();
		view.addObject("s", dao2.detail(id));
		
		view.addObject("q", dao.detail(q_no));
		view.addObject("viewPage", "member/detailQuestion.jsp");
		view.setViewName("templateE");
		return view;
		
	}
	
	
}
