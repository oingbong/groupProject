package com.daeDing.controller_cart;

import java.io.FileOutputStream;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.CartDao;
import com.daeDing.dao.GoodsDao;
import com.daeDing.vo.CartVo;
import com.daeDing.vo.GoodsVo;

@Controller
@RequestMapping("/member/insertCart.do")
public class InsertCartController_cart {

	@Autowired
	private CartDao dao;

	public void setDao(CartDao dao) {
		this.dao = dao;
	}


	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView submit(HttpServletRequest request) {
		System.out.println("�μ�ƮīƮ�Դϴ�");
		ModelAndView view = new ModelAndView();
		String c_id = (String)request.getSession().getAttribute("m_id");
		int c_goodsno = Integer.parseInt(request.getParameter("no"));
		int c_goodscnt = Integer.parseInt(request.getParameter("cnt"));
		int c_goodsprice = Integer.parseInt(request.getParameter("price"));
		System.out.println("īƮ�Դϴ�"+"  ���̵� : "+c_id+"  ��ǰ��ȣ : "+c_goodsno+"  ��ǰ���� : "+c_goodscnt+"  ��ǰ���� : "+c_goodsprice);
		CartVo c = new CartVo(0, c_id, c_goodsno, c_goodscnt, c_goodsprice);
		System.out.println("c�Ϸ�");
		int re = dao.insert(c);
		
		view.addObject("re", re);
		System.out.println(re);

		if (re == 1) {
			view.setViewName("redirect:/member/listCart.do");
		} else {
			//view.addObject("msg", "��ǰ��Ͽ� �����Ͽ����ϴ�.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
		}

		return view;
	}

}