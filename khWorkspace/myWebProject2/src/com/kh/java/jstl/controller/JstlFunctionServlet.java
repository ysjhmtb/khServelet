package com.kh.java.jstl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jstlFn.do")
public class JstlFunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public JstlFunctionServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String text = request.getParameter("inputText");
		
		RequestDispatcher view = request.getRequestDispatcher("views/jstl/jstlFn.jsp");
		request.setAttribute("text", text);
			
		view.forward(request, response);
		
		
	}

}
