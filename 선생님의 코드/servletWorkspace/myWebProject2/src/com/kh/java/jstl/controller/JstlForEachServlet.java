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
		Member m1 = new Member("연제각", 28, "010-222-2222");
		Member m2 = new Member("나신의", 24, "010-333-3333");
		Member m3 = new Member("전유민", 25, "010-555-5555");
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		RequestDispatcher view 
						= request.getRequestDispatcher("views/jstl/jstlForEach.jsp");
		request.setAttribute("team", list);
		view.forward(request, response);
	}
}











