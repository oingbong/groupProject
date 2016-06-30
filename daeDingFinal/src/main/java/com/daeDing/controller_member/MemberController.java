package com.daeDing.controller_member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.MemberDao;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao dao;
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/member/listMember.do")
	public ModelAndView list(){
		ModelAndView view = new ModelAndView();
		view.addObject("list", dao.list());
		view.addObject("viewPage", "member/listMember.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/listMember");
		return view;
	}
	
	@RequestMapping("/member/detailMember.do")
	public ModelAndView detail(String m_id){
		ModelAndView view = new ModelAndView();
		view.addObject("m", dao.detail(m_id));
		view.addObject("viewPage", "member/detailMember.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/detailMember");
		return view;
	}
	
	@RequestMapping("/member/deleteMember.do")
	public ModelAndView delete(String m_id){
		ModelAndView view = new ModelAndView();
		int re = dao.delete(m_id);
		if(re >= 1){
			view.setViewName("redirect:/member/listMember.do");
		}else{
			view.addObject("msg", "회원정보 삭제에 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}
		return view;
	}
}
