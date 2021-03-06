package com.kh.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu.do")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전달 값에 대한 한글 인코딩 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//전달 값 변수에 저장
		String menu = request.getParameter("menu");
		
		System.out.println("내가 선택 한 오늘 메뉴는 : " + menu);
		
		//로직
		//메뉴명 -> 해당 메뉴를 어디로 가서 먹는지 식당이름
		//XX를 먹으러 ~~로 갑시다!!
		String res = "";
		switch(menu){
		case "김치찌개":
			res = "대독장";
			break;
		case "탕수육":
			res = "중리";
			break;
		case "스팸":
			res = "편의점";
			break;
		case "김치볶음밥":
			res = "소풍";
			break;
		}
		
		String message = menu + "을(를) 먹으러 " + res + "에 갑시다~!!";
		
		//forward
		RequestDispatcher rd = request.getRequestDispatcher("/menuAck.do");
		request.setAttribute("outputMessage", message);
		rd.forward(request, response);
	}
}


























