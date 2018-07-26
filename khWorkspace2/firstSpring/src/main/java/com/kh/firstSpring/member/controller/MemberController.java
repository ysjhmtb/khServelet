package com.kh.firstSpring.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.firstSpring.member.model.service.MemberService;
import com.kh.firstSpring.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("memberList.do")
	public String memberList(){	
		return "member/memberList";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(Member member, HttpSession session){
		Member user = memberService.selectMember(member);
		System.out.println(user);
		
		if(user != null && user.getPassword().equals(member.getPassword())){
			session.setAttribute("user", user);
		}else{
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		return "index";
	}
	
	@RequestMapping(value="logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:index.do";
	}
	
	@RequestMapping("memberJoinForm.do")
	public String memberJoinForm(){
		return "member/memberJoin";
	}
	
	@RequestMapping("join.do")
	public String memberJoin(Member member){
		memberService.insertMember(member);
		return "redirect:index.do";
	}
	
	@RequestMapping(value="idCheck.do", produces="application/text;charset=UTF-8")
	public @ResponseBody String checkMemberId(String id) {
		System.out.println(id);
		
		Member member = new Member();
		member.setUserid(id);
		member = memberService.selectMember(member);
		return member == null ? "사용가능한 아이디입니다." : "중복된 아이디 입니다.";
	}
	
	@RequestMapping("memberUpdateForm.do")
	public String memberUpdateForm() {
		return "member/memberUpdate";
	}
	
}











