package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.dd")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송 값에 한글이 있을 경우 한글 처리
		//EncodingFilter가 설정 됨
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pwd");
		
		System.out.println("id : " + id + ", pwd : " + pass);
		
	}

}









