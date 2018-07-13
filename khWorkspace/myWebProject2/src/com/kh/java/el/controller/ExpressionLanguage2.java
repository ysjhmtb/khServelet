package com.kh.java.el.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/el2.do")
public class ExpressionLanguage2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExpressionLanguage2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "최범석");
		map.put("age", "20");
		map.put("phone", "010-3242-3277");
		
		request.setAttribute("memberMap", map);
		RequestDispatcher view = request.getRequestDispatcher("views/el/el2.jsp");
		view.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}





