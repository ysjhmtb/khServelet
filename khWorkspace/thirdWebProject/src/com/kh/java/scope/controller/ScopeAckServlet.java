package com.kh.java.scope.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeAckServlet
 */
@WebServlet("/scopeAck.do")
public class ScopeAckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScopeAckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//페이지 영역의 변수는 접근이 불가능하다.
		//그래서 int sum = sum 이 무의미.
		
		
		//request scope의 값 저장. getAttribute 가 Object를 반환.
		int reqSum = request.getAttribute("requestSum") == null ?
				0 : (Integer) request.getAttribute("requestSum");
		
		//session scope의 값 저장.
		//false를 선택하면 세션 생성 시 기존에 세션이 있다면 해당 세션을 반환.
		//기존에 생성된 세션이 없다면 세션을 반환하지 않는다.
//		HttpSession session = request.getSession(false);
		HttpSession session = request.getSession();
		int sessionNum = session.getAttribute("sessionSum") == null?
				0 : (Integer)session.getAttribute("sessionSum");
		
		//application scope의 값 저장.
		ServletContext application = getServletContext();
		int applicationNum = application.getAttribute("applicationSum") == null?
				0 : (Integer)application.getAttribute("applicationSum");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title> scope test </title></head>");
		
		out.println("<body>");
		out.println("<h2>page 영역 </h2>");
		
		out.println("<p>해당 페이지 영역 내에서만 존재하는 값의 범위.<br>"
		+"페이지 이동 시엔 값이 사라짐.</p>");
		
		out.println("<h2>request 영역 </h2>");
		out.println("<p>각 페이지간 전달되는 영역까지 존재하는 값의 범위. (다음 페이지.)</p>");
		out.println("계산 결과 : "+reqSum +"<br>");
		
		out.println("<h2>session 영역 </h2>");
		out.println("<p>application과 연결이 유지되는 동안 존재하는 값의 범위.<br>"
		+"브라우저가 종료되기 전까지 값이 유지. </p>");
		out.println("계산 결과 : " + sessionNum +"<br>");
		
		out.println("<h2>application 영역 </h2>");
		out.println("<p>서버가 실행되고 있는 동안 유지되는 값의 범위.(서버가 켜져 있다면 계속 유지된다.)"
		+"서버를 사용하는 모든 사용자들이 접근 가능한 메모리.</p>");
		out.println("계산 결과 : "+applicationNum +"<br>");
		out.println("<a href='/twp/index.html'>메인 페이지로 이동 </a>");
		
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
