package com.kh.java.el.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.el.model.vo.Member;

@WebServlet("/el6.do")
public class ExpressionLanguage6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExpressionLanguage6() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m1 = new Member("최범석", 20, "010-3242-3277");
		request.setAttribute("member", m1);
		
		Member m2 = new Member("홍길동", 30, "010-1111-2222");
		request.getSession().setAttribute("member", m2);
		
		RequestDispatcher view = request.getRequestDispatcher("views/el/el6.jsp");
		view.forward(request, response);
	}
}














