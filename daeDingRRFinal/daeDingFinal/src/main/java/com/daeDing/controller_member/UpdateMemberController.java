package com.daeDing.controller_member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.MemberDao;
import com.daeDing.vo.MemberVo;

@Controller
@RequestMapping("/member/updateMember.do")
public class UpdateMemberController {
	
	@Autowired
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(String m_id){
		ModelAndView view = new ModelAndView();
		MemberVo m = dao.detail(m_id);
		view.addObject("m", m);
		view.addObject("viewPage", "member/updateMember.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/updateMember");
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(MemberVo m){
		ModelAndView view = new ModelAndView();
		int re = dao.update(m);
		if(re >= 1){
			view.setViewName("redirect:/member/listMember.do");
		}else{
			view.addObject("msg", "회원정보 수정에 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}
		return view;
	}
}
