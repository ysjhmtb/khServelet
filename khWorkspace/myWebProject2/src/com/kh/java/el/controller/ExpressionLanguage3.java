package com.kh.java.el.controller;

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

@WebServlet("/el3.do")
public class ExpressionLanguage3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExpressionLanguage3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list = new ArrayList<Member>(); 
		Member m1 = new Member("최범석", 20, "010-3242-3277");
		Member m2 = new Member("홍길동", 30, "010-1111-2222");
		list.add(m1);
		list.add(m2);
		
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("views/el/el3.jsp");
		view.forward(request, response);
	}
}





