package com.daeDing.controller_notice;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.NoticeDao;

@Controller
@RequestMapping("/member/deleteNotice.do")
public class DeleteNoticeController {

	@Autowired
	private NoticeDao dao;
	
	public void setDao(NoticeDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(int n_no)
	{
		ModelAndView view = new ModelAndView();
		view.addObject("n_no", n_no);
		view.addObject("viewPage","member/deleteNotice.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(int n_no, String n_pwd, HttpServletRequest request)
	{
		System.out.println("doPost Call!!");
		String path = request.getRealPath("/resources/notice");
		String oldFname = dao.getNotice(n_no, false).getN_fname();
		ModelAndView view = new ModelAndView();
		int re =dao.deleteNotice(n_no, n_pwd);
		if(re == 1)
		{
			if(oldFname != null && !oldFname.equals(""))
			{
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			
			view.setViewName("redirect:/member/listNotice.do");
		}
		else
		{
			System.out.println("삭제실패!");
			view.addObject("msg", "게시물 삭제에 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}
		return view;
	}
}






