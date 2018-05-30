package com.kh.java.info.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/info.do")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("프로토콜 : " + request.getProtocol());
		System.out.println("서버명 : " + request.getServerName());
		System.out.println("웹 루트 경로 : " + request.getContextPath());
		System.out.println("현재 경로 : " + request.getRequestURI());
		System.out.println("요청자 IP 정보 : " + request.getRemoteAddr());
		System.out.println("");
	}

}
