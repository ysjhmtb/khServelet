package com.kh.firstSpring.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.firstSpring.notice.model.vo.Notice;

@Controller
public class NoticeController {
	
	@RequestMapping("paramTest.do")
	public String paramTest(int no,
									String title){
		System.out.println(no);
		System.out.println(title);
		return "home";
	}
	@RequestMapping("paramTest1.do")
	public String paramTest1(@RequestParam("no")int number,
									@RequestParam("title")String title){
		System.out.println(number);
		System.out.println(title);
		return "home";
	}
	@RequestMapping("paramTest2.do")
	public String paramTest2(Notice notice){
		System.out.println(notice.toString());
		return "home";
	}
	
	@RequestMapping("returnParam.do")
	public String returnParameter(Notice notice, Model model){
		model.addAttribute("notice", notice);
		return "param/printParam";
	}
	
	@RequestMapping("returnParam1.do")
	public ModelAndView returnParameter1(Notice notice, ModelAndView mv){
		mv.addObject("notice", notice);
		mv.setViewName("param/printParam");
		return mv;
	}

	@RequestMapping("printNotice.do")
	public ModelAndView printNotice(Notice notice, ModelAndView mv){
		System.out.println(notice);
		mv.addObject("notice", notice);
		mv.setViewName("param/printParam1");
		return mv;
	}
	
	
	
	
}









