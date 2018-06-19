package com.kh.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request, response
		//요청 값 중 한글이 있을 경우 한글 처리
		request.setCharacterEncoding("utf-8");
		//보내는 값 중 한글이 있을 경우 처리
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>서블릿 이란?</title></head>");
		out.println("<body>");
		out.println("<h1>서블릿 이란?</h1>");
		out.println("<h3>서블릿은 서버의 기능과 화면을 구성하는 HTML소스를 같이 저장 하고 있다.<br>"
				+ "클라이언트의 요청 값을 받을 수 있다.<br>"
				+ "화면을 구성하는 기능과 서버의 기능을 같이 구현하는 기술을 서블릿 이라고 한다.</h3>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
