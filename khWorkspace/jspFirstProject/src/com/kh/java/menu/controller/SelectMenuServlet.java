package com.kh.java.menu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectMenuServlet
 */
@WebServlet("/selectMenu.do")
public class SelectMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송 값에 한글이 있을 경우 인코딩 처리.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		//2. 전송 값 변수에 저장.
		String menu = request.getParameter("menu");
		
		//3. 비지니스 로직 -> 서비스 호출
		//메뉴별 식당이름, 금액을 정한다.
		String name = "";
		String menuStr = "";
		int price = 0;
		
		switch(menu) {
		case "food1":
			name = "소풍";
			menuStr = "라.돈.밥";
			price = 7000;
			break;
		case "food2":
			name = "편의점";
			menuStr = "누네띠네";
			price = 2000;
			break;
		case "food3":
			name = "미스터 김밥 옆에 있는 가게.";
			menuStr = "콩나물국밥";
			price = 6000;
			break;
		case "food4":
			name = "소풍";
			menuStr = "라볶이";
			price = 4000;
			break;
		case "food5":
			name = "kh정보교육원";
			menuStr = "null";
			price = 0;
			break;
			
		}
		
		
		
		//4. 결과값 화면 출력(전송 값 전달.)
		//다음 화면, 다음 서블릿으로 값을 전달할 때 사용할 스코프.
		request.setAttribute("name", name);
		request.setAttribute("menu", menuStr);
		request.setAttribute("price", price);
		
		
		RequestDispatcher view = request.getRequestDispatcher("views/4.menuResult.jsp");
		view.forward(request, response);
		
		
	}

}
