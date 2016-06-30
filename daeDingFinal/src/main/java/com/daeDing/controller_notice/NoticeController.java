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
		
		
		//�˻��� ���¿��� ����¡ó���� ���� �ڵ�
		if(sort != null){
			session.setAttribute("sort", sort);
		}
		
		System.out.println("my:"+my);
		
		//"�������۸� �˻����̾�"��� ���������� ���� ����
		if(my != null){
			session.setAttribute("my", "1");
		}
				
				
		
		//���࿡ �˻�� ������ �ȴٸ�
		//����¡ó���� ���Ͽ� �������� ��ų �ʿ䰡 �ִ�.
		if(keyword != null){
			session.setAttribute("searchField", searchField);
			session.setAttribute("keyword", keyword);
		}
				
		//�˻�� �Է����� �ʰ� �˻��� �������� �̹� �ִ� ������ Ŭ����
		if(keyword != null && keyword.equals("")){
			session.setAttribute("searchField", null);
			session.setAttribute("keyword", null);
		}
				
		// �̹� session�� �Ƿ� ������ dao���� ������ ���� ���� �� ����.
		// ���࿡ list�� �ö� keyword�� ������ null�� ������ �ȴ�. 
		
		// ���ʿ� list�� ������ ==> null����
		// �ѹ� �˻��� ����==> session�� �Ǹ� �� ����.
		// �ѹ� �˻��� ���¿��� ������ ��ȣ ������ ��==> session �� ����
		// �ѹ� �˻��� ���¿��� �˻��� �Է� ���ϰ� �˻� ==> 
		
				
		ModelAndView view = new ModelAndView();
		//view.setViewName("/member/listBoard");
		
		String m_id = null;
		//�������� �˻������̶�� ���ǿ� �Ǹ� id�� �о�´�.
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









