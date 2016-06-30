package com.daeDing.controller_goods;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.GoodsDao;
import com.daeDing.vo.GoodsVo;

@Controller
@RequestMapping("/member/insertGoods.do")
public class InsertGoodsController_goods {

	@Autowired
	private GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form() {

		ModelAndView view = new ModelAndView();

		view.addObject("viewPage", "member/insertGoods.jsp");
		view.setViewName("templateE");
		//view.setViewName("/member/insertGoods");

		return view;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(GoodsVo g, HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView();

		// 업로드 할 파일복사를 처리한다.
		String path = request.getRealPath("/resources/upload");

		System.out.println("path : " + path);

		// 사용자가 업로드 한 파일이 있는지 파악한다.

		MultipartFile uploadFile = g.getG_uploadimg();

		if (uploadFile != null) {
			String fileName = uploadFile.getOriginalFilename();
			g.setG_img(fileName);
			try {
				// 사용자가 업로드한 파일의 내용을 byte[]에 담는다.
				byte[] data = uploadFile.getBytes();
				// 출력하기 위한 파일객체를 생성한다.
				FileOutputStream output = new FileOutputStream(path + "/" + fileName);
				output.write(data);
				output.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}

		int re = dao.insert(g);
		view.addObject("re", re);
		System.out.println(re);

		if (re == 1) {
			view.setViewName("redirect:/member/listGoods.do");
		} else {
			//view.addObject("msg", "물품등록에 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
		}
		return view;
	}

}
