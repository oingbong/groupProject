package com.daeDing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.daeDing.dao.QuestionDao;

@Controller
@RequestMapping("/member/sendMail.do")
public class MailController {
	@Autowired
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@Autowired
	private QuestionDao dao;
	
	public void setDao(QuestionDao dao) {
		this.dao = dao;
	}

	public ModelAndView form(){
		ModelAndView view = new ModelAndView();
		view.addObject("viewPage", "member/sendMail.jsp");
		view.setViewName("template");
		return view;
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView mail(int q_no, String q_answer, int q_yesNo, String q_email){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setSubject("문의하신 질문에 대한 답변입니다. DaeDing:)");
		mailMessage.setFrom("pommeooo@naver.com");
		mailMessage.setText(q_answer);
		mailMessage.setTo(q_email);
		try {
			mailSender.send(mailMessage);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
		ModelAndView view = new ModelAndView();
		
		//문의 사항 처리 유무
		view.addObject("a", dao.update_yesNo(q_no));
		
		view.setViewName("redirect:/member/listQuestion.do");
		return view;
	}
}
