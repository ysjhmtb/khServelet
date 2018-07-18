package com.kh.java.jstl.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlFmt.do")
public class JstlFmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JstlFmtServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int price = 8700000;
		float percent = 0.88f;
		Date now = new Date();
		
		request.setAttribute("price", price);
		request.setAttribute("percent", percent);
		request.setAttribute("now", now);
		
		RequestDispatcher view 
						= request.getRequestDispatcher("views/jstl/jstlFmt.jsp");
		view.forward(request, response);
	}
}











