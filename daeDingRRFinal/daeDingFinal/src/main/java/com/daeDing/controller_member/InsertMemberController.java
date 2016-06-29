package com.daeDing.controller_member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.MemberDao;
import com.daeDing.vo.MemberVo;

@Controller
@RequestMapping("/insertMember.do")
public class InsertMemberController {
	@Autowired
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(){
		ModelAndView view = new ModelAndView();
		view.addObject("viewPage","insertMember.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/insertMember");
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(MemberVo m){
		ModelAndView view = new ModelAndView();
		int re = dao.insert(m);
		if(re==1){
			view.setViewName("redirect:/login.do");
		}else{
			view.addObject("msg", "회원 추가를 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}
		return view;
	}
}
