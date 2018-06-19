package com.kh.java.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.MemberVo;

/**
 * Servlet implementation class DeleteMemberServlet
 */
@WebServlet("/deleteMember.do")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 파라미터 값 변수에 저장
		//화면에서 쿼리스트링을 이용하여 전송 한 값
		String id = request.getParameter("userid");
//		System.out.println("id1 : " + id);
		
		//세션에 저장된 아이디 값
//		HttpSession session = request.getSession();
//		MemberVo user = (MemberVo)session.getAttribute("user");
//		String id2 = user.getUserId();
//		System.out.println("id2 : " + id2);
		
		//2. 비지니스 로직 호출
		MemberService ms = new MemberService();
		int result = ms.deleteMember(id);
		
		if(0 < result){
			//탈퇴 정상 처리
			//session user 삭제 -> main page
			HttpSession session = request.getSession();
			//세션값 삭제
			session.invalidate();
			response.sendRedirect("index.jsp");
		}else{
			//정상 처리 X
			//에러페이지 -> 회원 탈퇴 중 문제가 발생하였습니다.
			RequestDispatcher view 
						= request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "회원 탈퇴 중 문제가 발생하였습니다.");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}











