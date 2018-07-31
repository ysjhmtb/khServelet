package com.kh.firstSpring.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.firstSpring.notice.model.service.NoticeService;
import com.kh.firstSpring.notice.model.vo.Notice;


@Controller
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("paramTest.do")
	public String paramTest(int no, String title) {
		
		System.out.println(no);
		System.out.println(title);
		
		return "home";
	}
	
	@RequestMapping("paramTest1.do")
	public String paramTest1(@RequestParam("no")int number, 
			@RequestParam("title")String title) {
		
		System.out.println(number);
		System.out.println(title);
		
		return "home";
	}
	
	@RequestMapping("paramTest2.do")
	public String paramTest2(Notice notice) {
		
		System.out.println(notice.toString());
		return "home";
	}
	
	
	@RequestMapping("returnParam.do")
	public String returnParameter(Notice notice, Model model) {
		
		//Model의 목적은 객체 추가? 세션에 추가하는 것과의 차이?
		//세션은 브라우저가 종료되기 전까지 유지되지만 Model은 다음 페이지까지 유지.
		//Model을 Request처럼 생각하면 된다.
		
		model.addAttribute("notice", notice);
		return "param/printParam";
	}
	
	@RequestMapping("returnParam1.do")
	public ModelAndView returnParameter1(Notice notice, ModelAndView mv) {
		
		mv.addObject("notice", notice);
		mv.setViewName("param/printParam");
		return mv;
	}
	
	@RequestMapping("printNotice.do")
	public ModelAndView printNotice(Notice notice, ModelAndView mv) {
		
		mv.addObject("notice", notice);
		mv.setViewName("param/printParam1");
		return mv;
	}
	
	
	/*
	 공지사항 테이블 수정.
	 ALTER TABLE NOTICE ADD (ATTACH VARCHAR2(1000));
	 
	 */ 
	
	 @RequestMapping("noticeList.do")
	 public ModelAndView noticeList(ModelAndView mv) {
		 
		 List<Notice> list = noticeService.selectNoticeList();
		 mv.addObject("list",list);
		 mv.setViewName("notice/noticeList");
		 return mv;
		 
	 }
	 
	 
	 @RequestMapping("noticeDetail.do")
	 public ModelAndView noticeDetail(@RequestParam("noticeNo")int no, ModelAndView mv) {
		 
		 Notice notice = noticeService.selectNotice(no);
		 System.out.println("notice : " + notice);
		 mv.addObject("notice", notice);
		 mv.setViewName("notice/noticeDetail");
		 return mv;
	 }
	 
	 
	 @RequestMapping("writeNoticeForm.do")
	 public String writeNoticeForm() {
		 return "notice/noticeForm";
	 }
	 
	 
	 @RequestMapping("writeNotice.do")
		public String writeNotice(Notice notice, 
							@RequestParam("file") MultipartFile file,
							HttpServletRequest request) throws Exception{
			System.out.println(notice);
			System.out.println(file.getOriginalFilename());
			
	
			
			//webapp 밑의 resources
			
			
			String root = request.getSession().getServletContext().
					getRealPath("resources");
			
			String path = root + "/upload";
			String filePath = "";
			System.out.println(path);
			
			File folder = new File(path);
			
			if(!folder.exists()) {
				folder.mkdir();
			}
			
			filePath = path + "/" + file.getOriginalFilename();
			System.out.println(filePath);
			
			try {
				
				file.transferTo(new File(filePath));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			notice.setAttach(file.getOriginalFilename());
			
			
			String view = "redirect:noticeList.do";
			try{
				int result = noticeService.insertNotice(notice);
			}catch(Exception e){
				view = "error";
			}
			return view;
			
		}
	 
	 @RequestMapping("updateNoticeForm.do")
		public ModelAndView updateNoticeForm(ModelAndView mv, int no){
		 	System.out.println("no : " + no);
			Notice notice = noticeService.selectNotice(no);
			System.out.println("notice : " + notice); 
			mv.addObject("notice", notice);
			mv.setViewName("notice/noticeUpdateForm");
			return mv;
		}
	 
	 @RequestMapping("updateNotice.do")
	 public String updateNotice(Notice notice, 
			 @RequestParam("addedFile") MultipartFile file,
			 HttpServletRequest request) {
		 
		 
		 
		 //기존 파일 삭제 
		 	String root = request.getSession().getServletContext().
					getRealPath("resources");
			String path = root + "/upload";
			System.out.println(path);
			String filePath = "";
			File folder = new File(path);
			
			
			
			filePath = folder + "/" + notice.getAttach();
			
			File oldFile = new File(filePath);
			if(oldFile.exists()) {
				oldFile.delete();
			}
			
			
			//새로운 파일 저장
			
			String newFilePath = folder + "/" + file.getOriginalFilename();

			try {
				
				file.transferTo(new File(newFilePath));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			notice.setAttach(file.getOriginalFilename());
			
			int result = noticeService.updateNotice(notice);
		 
		 
		 
		System.out.println("updateNotice.do");
		 return "redirect:noticeDetail.do?noticeNo=" + notice.getNo();
		 
	 }
 
	 
	 @RequestMapping("deleteNotice.do")
	 public String deleteNotice(Notice notice, HttpServletRequest request) {
		 
		//기존 파일 삭제 
	 	String root = request.getSession().getServletContext().
				getRealPath("resources");
		String path = root + "/upload";
		System.out.println(path);
		String filePath = "";
		File folder = new File(path);
		
		
		
		filePath = folder + "/" + notice.getAttach();
		
		File oldFile = new File(filePath);
		if(oldFile.exists()) {
			oldFile.delete();
		}
		 
		int result = noticeService.deleteNotice(notice);
		 
		 return "redirect:noticeList.do";
	 }
	 
	 
	
	
}
