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

@WebServlet("/selectMember.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MemberServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		Member member = new MybatisService().selectMember(userid);
		System.out.println(member.toString());
		
		RequestDispatcher view = request.getRequestDispatcher("views/mybatis/memberPage.jsp");
		request.setAttribute("member", member);
		view.forward(request, response);
		
	}

}
