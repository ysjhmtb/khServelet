package com.kh.java.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2.do")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet2() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("서버에서 전송한 값입니다!!!");
		
	}
}













