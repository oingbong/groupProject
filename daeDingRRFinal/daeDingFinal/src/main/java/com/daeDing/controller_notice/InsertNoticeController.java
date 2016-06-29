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
		//���ó���� ������ �Ӽ�
		//b_ref			�θ��:�۹�ȣ�� ����		���:�θ�۰� �����ϰ�
		//b_level		�θ��:0					���:�θ�ۺ��� 1����
		//b_step		�θ��:0					���:�θ�ۺ��� 1����(�̹� �ִ� ��۵��� b_step�� 1������)
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
		
		//���ο� �۹�ȣ�� ���´�.
		int n_no = dao.nextNo();
		
		//Ŀ��� ������Ʈ�� b�� no�� 0�� �ƴ� ���̶�� ����̴�!!
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
			view.addObject("msg", "�Խù� ��Ͽ� �����Ͽ����ϴ�.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}
		return view;
	}
}



