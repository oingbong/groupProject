package com.daeDing.controller_notice;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.NoticeDao;

@Controller
public class NoticeController {

	@Autowired
	private NoticeDao dao;
	
	public void setDao(NoticeDao dao) {
		this.dao = dao;
	}
		
	@RequestMapping("/member/detailNotice.do")
	public ModelAndView detail(int n_no)
	{
		ModelAndView view = new ModelAndView();
		view.addObject("n", dao.getNotice(n_no, true));
		view.addObject("viewPage", "member/detailNotice.jsp");
		view.setViewName("templateE");
		return view;
	}
	

	@RequestMapping("/member/listNotice.do")
	public ModelAndView list(String my, String sort, String searchField, String keyword,  @RequestParam(value="pageNUM",defaultValue="1") int pageNUM, HttpSession session)
	{	
		//System.out.println("id:"+id);		
		
		
		//검색된 상태에서 페이징처리를 위한 코드
		if(sort != null){
			session.setAttribute("sort", sort);
		}
		
		System.out.println("my:"+my);
		
		//"내가쓴글만 검색중이야"라는 상태유지를 위한 변수
		if(my != null){
			session.setAttribute("my", "1");
		}
				
				
		
		//만약에 검색어가 전달이 된다면
		//페이징처리를 위하여 상태유지 시킬 필요가 있다.
		if(keyword != null){
			session.setAttribute("searchField", searchField);
			session.setAttribute("keyword", keyword);
		}
				
		//검색어를 입력하지 않고 검색을 눌렀을때 이미 있는 세션을 클리어
		if(keyword != null && keyword.equals("")){
			session.setAttribute("searchField", null);
			session.setAttribute("keyword", null);
		}
				
		// 이미 session에 실려 있으니 dao에게 세션의 값을 전달 해 주자.
		// 만약에 list로 올때 keyword가 없으면 null이 전달이 된다. 
		
		// 최초에 list를 때리면 ==> null전달
		// 한번 검색한 상태==> session에 실린 값 전달.
		// 한번 검색한 상태에서 페이지 번호 눌러서 옴==> session 값 전달
		// 한번 검색한 상태에서 검색어 입력 않하고 검색 ==> 
		
				
		ModelAndView view = new ModelAndView();
		//view.setViewName("/member/listBoard");
		
		String m_id = null;
		//내가쓴글 검색상태이라면 세션에 실린 id를 읽어온다.
		if(session.getAttribute("my") != null){
			m_id = (String)session.getAttribute("m_id");
		}
				
		view.addObject("list", dao.listNotice(m_id, pageNUM,(String) session.getAttribute("searchField"), (String)session.getAttribute("keyword"), (String)session.getAttribute("sort")));		
		
		view.addObject("pageStr", dao.getPageStr());
		view.addObject("viewPage", "member/listNotice.jsp");
		view.setViewName("templateE");
		return view;
	}
}









