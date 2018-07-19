package com.kh.java.mybatis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.mybatis.model.service.MybatisService;
import com.kh.java.mybatis.model.vo.Member;

@WebServlet("/updateMember.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MemberUpdate() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		
		Member member = new Member();
		member.setUserid(id);
		member.setAge(age);
		member.setUsername(name);
		member.setPhone(phone);

		int result = new MybatisService().updateMember(member);
		
		String url = "";
		if(result > 0) {
			request.setAttribute("member", member);
			url = "views/mybatis/memberPage.jsp";
			
		}else {
			//에러페이지로 이동 
		}
		
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
