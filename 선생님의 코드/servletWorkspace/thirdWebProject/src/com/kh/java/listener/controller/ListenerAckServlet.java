package com.kh.java.listener.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListenerAckServlet
 */
@WebServlet("/listenerAck.li")
public class ListenerAckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListenerAckServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>리스너 동작 확인</title></head>");
		out.println("<body>");
		out.println("전달 된 이름 : " + name);
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
