package com.kh.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResearchXmlServlet
 */
//@WebServlet("/researchXml.do")
public class ResearchXmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResearchXmlServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

		for (String food : foods) {
			System.out.print(food + " ");
		}

		// foodStr - 선택 된 음식의 이름으로 출력 + ,로 연결하여 출력
		String foodStr = "";
		for (int i = 0; i < foods.length; i++) {
			if (i == 0) {
				foodStr = changeName(foods[i]);
			} else {
				foodStr += ", " + changeName(foods[i]);
			}
		}

		// 사용자가 선택한 색에 따라 추천하는 옷을 설정하여 화면에 출력
		String reClothes = "";
		switch (color) {
		case "회색":
			reClothes = "후드 집업";
			break;
		case "파란색":
			reClothes = "청바지";
			break;
		case "흰색":
			reClothes = "백바지";
			break;
		case "상아색":
			reClothes = "야구모자";
			break;
		case "다홍색":
			reClothes = "앞치마";
			break;
		}

		// 화면 전송
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>취향 조사 결과화면</title></head>");
		out.println("<body>");
		out.println("<h2>개인 취향 테스트 결과(Get)</h2>");
		out.printf("<span>이름 : %s</span><br>", name);
		out.printf("<span style='color:skyblue; font-weight:bold'>좋아하는 색 : %s</span><br>", color);
		out.printf("<span style='color:skyblue; font-weight:bold'>좋아하는 동물 : %s</span><br>", animal);
		out.printf("<span style='color:skyblue; font-weight:bold'>좋아하는 음식 : %s</span><br>", foodStr);
		out.println("<hr>");

		out.print(color + "를 선택하신 당신 : " + reClothes + "가 어우리실 것 같네요.");
		out.println("</body>");
		out.println("</html>");
	}

	private String changeName(String food) {
		String result = "";
		switch (food) {
		case "food1":
			result = "피자";
			break;
		case "food2":
			result = "떡볶이";
			break;
		case "food3":
			result = "부대찌개";
			break;
		case "food4":
			result = "소고기";
			break;
		case "food5":
			result = "스팸";
			break;
		case "food6":
			result = "라면";
			break;
		}

		return result;
	}

}
