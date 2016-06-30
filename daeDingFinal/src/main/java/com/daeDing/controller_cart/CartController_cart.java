package com.daeDing.controller_cart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.CartDao;
import com.daeDing.dao.GoodsDao;
import com.daeDing.dao.MemberDao;
import com.daeDing.vo.CartVo;

@Controller
public class CartController_cart {

	@Autowired
	private CartDao dao;

	public void setDao(CartDao dao) {
		this.dao = dao;
	}

	@Autowired
	private MemberDao m_dao;

	public void setM_dao(MemberDao m_dao) {
		this.m_dao = m_dao;
	}


	@RequestMapping("/member/listCart.do")
	public ModelAndView list(HttpServletRequest request) {

		ModelAndView view = new ModelAndView();
		String m_id = (String)request.getSession().getAttribute("m_id");
		
		view.addObject("list", dao.list(m_id));
		view.addObject("viewPage", "member/listCart.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/listGoods");

		return view;
	}


	@RequestMapping("/member/deleteCart.do")
	public ModelAndView delete(int c_no) {

		ModelAndView view = new ModelAndView();

		int re = dao.delete(c_no);
		System.out.println(re);

		if (re == 1) {
			view.setViewName("redirect:/member/listCart.do");
		} else {
			view.addObject("msg", "삭제실패");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			// view.setViewName("error");
		}

		return view;

	}
	
	
	//주문하기
	
	@RequestMapping("/member/listbuyCart.do")
	public ModelAndView listbuy(HttpServletRequest request) {

		ModelAndView view = new ModelAndView();
		String m_id = (String)request.getSession().getAttribute("m_id");
		
		view.addObject("m", m_dao.detail(m_id));
		view.addObject("list", dao.list(m_id));
		view.addObject("viewPage", "member/listbuyCart.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/listGoods");

		return view;
	}
	
	
	

}