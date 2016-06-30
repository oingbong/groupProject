package com.daeDing.controller_goods;

import java.io.File;
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
@RequestMapping("/member/updateGoods.do")
public class UpdateGoodsController_goods {
	
	@Autowired
	private GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(int g_no){
		
		ModelAndView view = new ModelAndView();
		
		view.addObject("list", dao.detail(g_no));
		view.addObject("viewPage", "member/updateGoods.jsp");
		//view.setViewName("/member/updateGoods");
		view.setViewName("templateE");
		
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(GoodsVo g, HttpServletRequest request){
		
		// ��ǰ ������ ���ϵ� �����ǰ� �ϴ� �ڵ�
		String oldFname = dao.detail(g.getG_no()).getG_img();
		String path=request.getRealPath("/resources/upload");
		System.out.println("path : " + path);
		
		MultipartFile multipartFile = g.getG_uploadimg();
		String fname=multipartFile.getOriginalFilename();
		if(fname != null && !fname.equals("")){
			try {
				// ���� �ߺ� ������ ���� ���ϸ� + �ð�
				String curTime = System.currentTimeMillis()+"";
				String f1 = fname.substring(0, fname.indexOf(".")-1); //���ϸ�
				String f2 = fname.substring(fname.indexOf(".")+1); // Ȯ����
				fname = f1 + curTime + "." + f2;
				
				g.setG_img(fname);
				
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		ModelAndView view = new ModelAndView();
		int re = dao.update(g);
		view.addObject("re", re);
		
		if(re==1){
			if(fname != null && !fname.equals("") && oldFname !=null && !oldFname.equals("")){
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			view.setViewName("redirect:/member/listGoods.do");
		}else{
			// �Խù� ������ �����ߴµ� ���࿡ ÷�������� �ִٸ� �ش� ������ �����ϴ� �ڵ�
			if(fname != null && !fname.equals("")){
				File file = new File(path + "/" + fname);
				file.delete();
			}
			view.addObject("msg", "��ǰ��Ͽ� �����Ͽ����ϴ�.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("/member/error");
		}
		
		return view;
	}

}
