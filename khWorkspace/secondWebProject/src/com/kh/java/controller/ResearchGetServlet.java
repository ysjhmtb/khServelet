package com.kh.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResearchGetServlet
 */
@WebServlet("/researchGet.do")
public class ResearchGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResearchGetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 전송값에 한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");

		// 전송 값을 변수에 저장
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food");

		System.out.println("name : " + name);
		System.out.println("color : " + color);
		System.out.println("animal : " + animal);

		for(String food : foods){
			System.out.print(food + " ");
		}
		//배열 데이터를 , , ,
		String foodStr = "";
		for(int i = 0 ; i < foods.length ; i++){
			if(i == foods.length - 1){
				foodStr += foods[i];
			}else{
				foodStr += foods[i] + ", ";
			}
		}
		
		//화면 전송
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>취향 조사 결과화면</title></head>");
		out.println("<body>");
		out.println("<h2>개인 취향 테스트 결과(Get)</h2>");
		out.printf("<span>이름 : %s</span><br>", name);
		out.printf("<span style='color:skyblue; font-weight:bold'>좋아하는 색 : %s</span><br>", color);
		out.printf("<span style='color:skyblue; font-weight:bold'>좋아하는 동물 : %s</span><br>", animal);
		out.printf("<span style='color:skyblue; font-weight:bold'>좋아하는 음식 : %s</span><br>", foodStr);
		
		
		out.println("</body>");
		out.println("</html>");
		
		
		

	}

}
