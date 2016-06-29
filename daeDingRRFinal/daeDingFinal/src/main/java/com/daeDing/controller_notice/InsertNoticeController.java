package com.daeDing.controller_notice;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.MemberDao;
import com.daeDing.dao.NoticeDao;
import com.daeDing.vo.NoticeVo;

@Controller
@RequestMapping("/member/insertNotice.do")
public class InsertNoticeController {

	@Autowired
	private NoticeDao dao;
	
	public void setDao(NoticeDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	private MemberDao dao2;

	public void setDao2(MemberDao dao2) {
		this.dao2 = dao2;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(@RequestParam(value="n_no", defaultValue="0") int n_no, HttpSession session)
	{
		//답글처리와 관련한 속성
		//b_ref			부모글:글번호와 동일		답글:부모글과 동일하게
		//b_level		부모글:0					답글:부모글보다 1증가
		//b_step		부모글:0					답글:부모글보다 1증가(이미 있는 답글들의 b_step은 1씩증가)
		ModelAndView view = new ModelAndView();
		if(n_no != 0)
		{
			NoticeVo n = dao.getNotice(n_no, false);
			view.addObject("n_no", n_no);
			view.addObject("b_ref", n.getB_ref());
			view.addObject("b_level", n.getB_level());
			view.addObject("b_step", n.getB_step());
		}
		else
		{
			view.addObject("n_no", "0");
			view.addObject("b_ref", "0");
			view.addObject("b_level","0");
			view.addObject("b_step", "0");
		}
		
		String id=(String) session.getAttribute("m_id");
		view.addObject("s", dao2.detail(id));
		view.addObject("viewPage", "member/insertNotice.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(NoticeVo n, HttpServletRequest request)
	{
		String path = request.getRealPath("/resources/notice");
		System.out.println("path:"+path);
		//n.setIp(request.getRemoteAddr());
		
		ModelAndView view = new ModelAndView();
		
		//새로운 글번호를 얻어온다.
		int n_no = dao.nextNo();
		
		//커멘드 오브젝트의 b의 no가 0이 아닌 값이라면 답글이다!!
		if(n.getN_no() != 0)
		{
			dao.updateStep(n.getB_ref(), n.getB_step());
			n.setB_level(n.getB_level()+1);
			n.setB_step(n.getB_step()+1);
		}
		else
		{
			n.setB_ref(n_no);
			n.setB_level(0);
			n.setB_step(0);
		}
		
		n.setN_no(n_no);		
		
		MultipartFile uploadFile = n.getUploadFile();
		String n_fname = n.getUploadFile().getOriginalFilename();
		if(n_fname != null && !n_fname.equals(""))
		{
			try{
				byte []data = uploadFile.getBytes();
				n.setN_fname(n_fname);
				n.setN_fsize(data.length);
				
				FileOutputStream fos = new FileOutputStream(path + "/" + n_fname);
				fos.write(data);
				fos.close();
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		else
		{
			n.setN_fname("");
			n.setN_fsize(0);
		}
		
		
		int re = dao.insertNotice(n);
		if(re == 1)
		{
			view.setViewName("redirect:/member/listNotice.do");
		}
		else
		{
			view.addObject("msg", "게시물 등록에 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}
		return view;
	}
}



