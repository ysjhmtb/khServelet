package com.kh.java.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.mybatis.model.service.MybatisService;
import com.kh.java.mybatis.model.vo.Member;
import com.kh.java.mybatis.model.vo.Search;

@WebServlet("/searchMember.do")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberSearchServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition 
				= request.getParameter("condition");
		String keyword
				= request.getParameter("keyword");
		Search search = new Search();
		search.setCondition(condition);
		search.setKeyword(keyword);
		
		List<Member> list 
			= new MybatisService().selectMemberSearch(search); 
		
		
		
		
		
		
		
		
		
		
		
	}
}
