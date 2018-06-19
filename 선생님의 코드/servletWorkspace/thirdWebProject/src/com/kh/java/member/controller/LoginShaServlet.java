package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginShaServlet
 */
@WebServlet("/loginSha.au")
public class LoginShaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginShaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pwd");
		String originPass = (String)request.getAttribute("originPwd");
		
		System.out.println(id + " / " + originPass + " / " + pass);
		System.out.println(id + "/" + originPass + "/" + pass);
	}
}











