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
 * Servlet implementation class ListenerServlet
 */
@WebServlet("/listener.li")
public class ListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션이 있으면 기존의 세션을 반환, 없으면 새로 만들어서 반환. false가 아닌 경우.
		HttpSession session = request.getSession(false);
		if(session != null) {
			//기존의 세션이라면 저장된 값들을 모두 삭제하는 메소드.
			session.invalidate();
		}
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title> 리스너 테스트.</title></head>");
		out.println("<body>");
		
		out.println("<form method='get' action='listenerAck.li'>");
		
		out.println("이름 : <input type='text' name='name'>");
		
		out.println("<input type='submit' value='전송'>");
		
		
		
		
		out.println("</form>");
		
		out.println("<hr> <a href='/twp/index.html'>메인으로 이동.</a>");
		
		
		out.println("</body>");
		
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














