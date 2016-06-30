package com.daeDing.controller_notice;


import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.NoticeDao;
import com.daeDing.vo.NoticeVo;

@Controller
@RequestMapping("member/updateNotice.do")
public class UpdateNoticeController {

	@Autowired
	private NoticeDao dao;
	
	
	
	public void setDao(NoticeDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView form(int n_no)
	{
		ModelAndView view = new ModelAndView();
		view.addObject("n", dao.getNotice(n_no, false));		
		view.addObject("viewPage", "member/updateNotice.jsp");
		view.setViewName("templateE");
		return view;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(NoticeVo n, HttpServletRequest request)
	{
		//만약에 첨부파일이 수정된다면 기존에 있는 파일을 삭제해 줄 필요가있다.
		String oldFname = dao.getNotice(n.getN_no(), false).getN_fname();
		
		String path = request.getRealPath("/resources/notice");
		System.out.println("path:"+path);
		//b.setIp(request.getRemoteAddr());
		
		MultipartFile uploadFile = n.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals(""))
		{
			try{
				byte []data = uploadFile.getBytes();			
				
				// 파일 중복 방지를 위한 파일명 + 시간
				String curTime = System.currentTimeMillis()+"";
				String f1 = fname.substring(0, fname.indexOf(".")-1); //파일명
				String f2 = fname.substring(fname.indexOf(".")+1); // 확장자
				fname = f1 + curTime + "." + f2;
				
				n.setN_fname(fname);
				n.setN_fsize(data.length);
				
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
				
		int re = dao.updateNotice(n);
		ModelAndView view = new ModelAndView();
		if(re == 1)
		{
			if(fname != null && !fname.equals("") && oldFname != null && !oldFname.equals(""))
			{
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			
			view.setViewName("redirect:/member/listNotice.do");
		}
		else
		{
			//게시물 수정에 실패했는데 만약에 첨부파일이 있다면 해당 파일을 삭제한다.
			if(fname != null && !fname.equals(""))
			{
				File file = new File(path + "/" + fname);
				file.delete();
			}
			
			view.addObject("msg", "게시물 수정에 실패하였습니다.");
			view.addObject("viewPage", "member/error.jsp");
			view.setViewName("templateE");
			//view.setViewName("error");
		}		
		
		
		return view;
	}
}


