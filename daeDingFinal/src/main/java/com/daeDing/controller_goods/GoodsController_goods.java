package com.daeDing.controller_goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.GoodsDao;
import com.daeDing.dao.MemberDao;
import com.daeDing.vo.GoodsVo;

@Controller
public class GoodsController_goods {

	@Autowired
	private GoodsDao dao;
	
	@Autowired
	private MemberDao m_dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	public void setM_dao(MemberDao m_dao) {
		this.m_dao = m_dao;
	}

	@RequestMapping("/member/listGoods.do")
	public ModelAndView list(String type, HttpSession session) {

		ModelAndView view = new ModelAndView();
		System.out.println(type +"지타입넘어왔어요");

		view.addObject("list", dao.list(type));
		view.addObject("viewPage", "member/listGoods.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/listGoods");

		return view;
	}

	@RequestMapping("/member/detailGoods.do")
	public ModelAndView detail(int g_no) {

		ModelAndView view = new ModelAndView();

		view.addObject("list", dao.detail(g_no));
		view.addObject("viewPage", "member/detailGoods.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/detailGoods");

		return view;
	}

	@RequestMapping("/member/deleteGoods.do")
	public ModelAndView delete(int g_no, HttpServletRequest request) {

		String path = request.getRealPath("/resources/upload");
		String oldFname = dao.detail(g_no).getG_img();
		ModelAndView view = new ModelAndView();
		int re = dao.delete(g_no);

		if (re == 1) {
			if(oldFname != null && !oldFname.equals("")){
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			
			view.setViewName("redirect:/member/listGoods.do");
		} else {
			view.addObject("msg", "삭제실패");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}

		return view;

	}
	
	@RequestMapping("/member/buyInfoGoods.do")
	public ModelAndView buyInfo(int g_no) {

		ModelAndView view = new ModelAndView();

		view.addObject("list", dao.detail(g_no));
		view.addObject("viewPage", "member/buyInfoGoods.jsp");
		view.setViewName("templateE");

		return view;

	}

	@RequestMapping("/member/buyGoods.do")
	public ModelAndView buy(int g_no, int cnt, GoodsVo v, int g_saleprice, int g_delivery, HttpServletRequest request) {

		ModelAndView view = new ModelAndView();
		System.out.println(cnt);
		System.out.println(g_saleprice);
		System.out.println(g_delivery);
		
		String m_id = (String) request.getSession().getAttribute("m_id");
		
		view.addObject("m", m_dao.detail(m_id));

		view.addObject("cnt", cnt);
		view.addObject("oper", cnt * g_saleprice + g_delivery);
		view.addObject("list", dao.detail(g_no));
		
		view.addObject("viewPage", "member/buyGoods.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	

	
	
	

}
