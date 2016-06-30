package com.daeDing.controller_question;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.MemberDao;
import com.daeDing.dao.QuestionDao;
import com.daeDing.vo.QuestionVo;

@Controller
@RequestMapping("/member/insertQuestion.do")
public class InsertQuestionController {
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

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(HttpSession session){
		ModelAndView view = new ModelAndView();
		
		String m_id = (String) session.getAttribute("m_id");
		view.addObject("s", dao2.detail(m_id));
		view.addObject("viewPage", "member/insertQuestion.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/insertQuestion");
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(QuestionVo q){

		ModelAndView view = new ModelAndView();
		int re = dao.insert(q);
		if(re==1){
			view.setViewName("redirect:/member/listQuestion.do");
		}else{
			view.addObject("msg", "문의 메일쓰기를 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}
		return view;
	}

}
