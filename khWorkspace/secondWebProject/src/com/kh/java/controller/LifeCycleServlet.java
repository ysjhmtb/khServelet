package com.kh.java.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/lifeCycle.do")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    //해당 서블릿 요청 시 최초 1회만 호출 
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 생성~~!!(init())");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// 톰캣이 종료될 때 호출 
		System.out.println("서블릿 종료~~!!(destroy())");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get 방식으로 서블릿 요청시 호출됨.
		System.out.println("doGet 호출 ~~!!");
	}

}
