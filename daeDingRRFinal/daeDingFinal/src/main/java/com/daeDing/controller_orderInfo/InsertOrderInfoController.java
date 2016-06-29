package com.daeDing.controller_orderInfo;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.CartDao;
import com.daeDing.dao.OrderInfoDao;
import com.daeDing.vo.CartVo;
import com.daeDing.vo.OrderInfoVo;

@Controller
@RequestMapping("/member/insertOrderInfo.do")
public class InsertOrderInfoController {
	
	@Autowired
	private OrderInfoDao dao;

	public void setDao(OrderInfoDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	private CartDao dao2;
	
	
	public void setDao2(CartDao dao2) {
		this.dao2 = dao2;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView submit(HttpSession session){
		
		ModelAndView view = new ModelAndView();
		String m_id = (String)session.getAttribute("m_id");
		List<CartVo> list = dao2.list(m_id);
		int re= -1;
		for(CartVo c : list){
			OrderInfoVo v = new OrderInfoVo(0,null,c.getC_goodsprice(),m_id,c.getC_goodscnt(),c.getC_goodsno());
			re = dao.insert(v);
		}
		dao2.deleteAll();
		
	
		
		if (re > 0) {

			view.setViewName("redirect:/member/listOrderInfo.do");
			
		} else {
			

			//view.addObject("msg", "물품등록에 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			
		}
		
		return view;
	}
	


	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(OrderInfoVo v, CartVo c,int g_no){
		
		ModelAndView view = new ModelAndView();
		
		System.out.println("여기오니? 와라");
		System.out.println(v.getOi_date()+"date");
		System.out.println(v.getOi_price()+"price");
		System.out.println(v.getOi_id()+"id");
		System.out.println(v.getOi_buycount()+"buycount");
		System.out.println(v.getOi_goodsno()+"goodsno");
		
		
		System.out.println(c.getC_goodsno()+"장바구니에서넘어옴");
		
		v.setOi_goodsno(g_no);
		int re = dao.insert(v);
		
		view.addObject("re", re);
		System.out.println(re);
		
		
		if (re > 0) {

			view.setViewName("redirect:/member/listGoods.do");
			
		} else {
			

			//view.addObject("msg", "물품등록에 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			
		}
		
		return view;
	}
	
}