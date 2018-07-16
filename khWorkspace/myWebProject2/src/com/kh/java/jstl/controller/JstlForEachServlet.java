package com.kh.java.jstl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.el.model.vo.Member;


@WebServlet("/jstlForEach.do")
public class JstlForEachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JstlForEachServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Member> list = new ArrayList<Member>(); 
		Member m1 = new Member("전윤석",33,"010-1234-5678");
		Member m2 = new Member("김가영",20,"010-4321-8765");
		Member m3 = new Member("나신의",20,"010-5678-1234");
		Member m4 = new Member("김정인",20,"010-5555-1234");
		Member m5 = new Member("유지상",20,"010-2345-6789");
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("views/jstl/jstlForEach.jsp");
		
		request.setAttribute("team", list);
		view.forward(request, response);
		
	}

}
