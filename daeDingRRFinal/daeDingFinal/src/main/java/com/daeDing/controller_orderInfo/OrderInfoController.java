package com.daeDing.controller_orderInfo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.GoodsDao;
import com.daeDing.dao.MemberDao;
import com.daeDing.dao.OrderInfoDao;

@Controller
public class OrderInfoController {

	@Autowired
	private OrderInfoDao dao;

	@Autowired
	private GoodsDao g_dao;

	public void setDao(OrderInfoDao dao) {
		this.dao = dao;
	}
	
	
	
	public void setG_dao(GoodsDao g_dao) {
		this.g_dao = g_dao;
	}



	@RequestMapping("/member/listOrderInfo.do")
	public ModelAndView list(HttpServletRequest request) {

		ModelAndView view = new ModelAndView();
		
		String m_id = (String)request.getSession().getAttribute("m_id");

		view.addObject("list", dao.list(m_id));

		view.addObject("viewPage", "member/listOrderInfo.jsp");
		System.out.println("여기까지?");
		view.setViewName("templateE");

		return view;

	}

	

}
