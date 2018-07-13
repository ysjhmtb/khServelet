package com.kh.java.el.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.el.model.vo.Member;

@WebServlet("/el1.do")
public class ExpressionLanguage1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExpressionLanguage1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m = new Member("최범석", 20, "010-3242-3277");
		request.setAttribute("member", m);
		
		RequestDispatcher view = request.getRequestDispatcher("views/el/el1.jsp");
		view.forward(request, response);
	}

}
