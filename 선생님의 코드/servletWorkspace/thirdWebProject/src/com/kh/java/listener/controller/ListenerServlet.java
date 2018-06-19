package com.kh.java.listener.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/listener.li")
public class ListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListenerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session이 있으면 기존의 세션을 반환, 
		//없으면 새로 만들어서 반환
		HttpSession session = request.getSession(false);
		if(session != null){
			//세션에 저장된 값을 모두 삭제
			session.invalidate();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>리스너 테스트</title></head>");
		out.println("<body>");
		out.println("<form method='get' action='listenerAck.li'>");
		out.println("이름 : <input type='text' name='name'/>");
		out.println("<input type='submit' value='전송'/>");
		out.println("</form>");
		out.println("<hr><a href='/twp/index.html'>메인으로 이동</a>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}







