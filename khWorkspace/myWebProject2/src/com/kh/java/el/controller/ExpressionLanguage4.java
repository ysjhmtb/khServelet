package com.kh.java.el.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.el.model.vo.Member;

@WebServlet("/el4.do")
public class ExpressionLanguage4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExpressionLanguage4() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member[] members = new Member[2];
		Member m1 = new Member("최범석", 20, "010-3242-3277");
		Member m2 = new Member("홍길동", 30, "010-1111-2222");
		members[0] = m1;
		members[1] = m2;
		
		request.setAttribute("member", members);
		RequestDispatcher view = request.getRequestDispatcher("views/el/el4.jsp");
		view.forward(request, response);
	}
}





