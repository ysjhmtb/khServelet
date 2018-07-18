package com.kh.java.jstl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jstlIf.do")
public class JstlIfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JstlIfServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		RequestDispatcher view = request.getRequestDispatcher("views/jstl/jstlIf.jsp");
		request.setAttribute("con", condition);
		view.forward(request, response);
	}
}











