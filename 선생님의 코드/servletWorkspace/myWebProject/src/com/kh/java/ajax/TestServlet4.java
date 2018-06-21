package com.kh.java.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test4.do")
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet4() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String food1 = request.getParameter("food1");
		String food2 = request.getParameter("food2");
		String food3 = request.getParameter("food3");
		
		System.out.println("오늘의 메뉴는 " + food1 + ", " + food2 + ", " + food3);
	}
}







