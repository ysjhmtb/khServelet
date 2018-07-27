package com.kh.firstSpring.notice.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.firstSpring.notice.model.service.NoticeService;
import com.kh.firstSpring.notice.model.vo.Notice;

@Controller
public class NoticeController {
	@Autowired
	NoticeService service;
	
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
	
	@RequestMapping("noticeList.do")
	public ModelAndView noticeList(ModelAndView mv){
		List<Notice> list = service.selectNoticeList();
		mv.addObject("list", list);
		mv.setViewName("notice/noticeList");
		return mv;
	}
	
	@RequestMapping("noticeDetail.do")
	public ModelAndView noticeDetail(ModelAndView mv, int no){
		Notice notice = service.selectNotice(no);
		System.out.println(notice);
		mv.addObject("notice", notice);
		mv.setViewName("notice/noticeDetail");
		return mv;
	}
	
	@RequestMapping("writeNoticeForm.do")
	public String writeNoticeForm(){
		return "notice/noticeForm";
	}
	
	@RequestMapping("writeNotice.do")
	public String writeNotice(Notice notice, 
						@RequestParam("file") MultipartFile file, HttpServletRequest request){
		System.out.println(notice);
		System.out.println(file.getOriginalFilename());
		
		//3. 파일 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String path = root + "\\upload";
		String filePath = "";
		File folder = new File(path);
		if(!folder.exists()){
			folder.mkdirs();
		}
		filePath = folder + "\\" + file.getOriginalFilename();
		
		System.out.println("filePath : " + filePath);
		try {
			file.transferTo(new File(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		notice.setAttach(file.getOriginalFilename());
		
		//int result = service.insertNotice(notice);
		
		
		return "redirect:noticeList.do";
	}
	
}









