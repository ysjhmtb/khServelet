package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet implementation class LoginWrapper
 */
@WebServlet("/LoginWrapper")
public class LoginWrapper extends HttpServletRequestWrapper implements Servlet {

	/**
	 * @see HttpServletRequestWrapper#HttpServletRequestWrapper(HttpServletRequest)
	 */
	public LoginWrapper(HttpServletRequest request) {
		//원본 request 객체를 부모 필드에 저장 
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getParameter(String name) {
		//특정 필드(pwd)에 대해서 값 변경 처리 
		
		if(null!=name && "pwd".equals(name)) {
			return super.getParameter(name) + "//값 변경 됨";
			
			
		}else {
			return super.getParameter(name);
		}
		
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
