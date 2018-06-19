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

@WebServlet("/login.au")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송 값에 한글이 있을 경우 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//전송값 변수에 저장
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		
		//서비스 호출
		MemberVo member = new MemberService().getMemberId(id);
		RequestDispatcher view = null;
		//1. 아이디가 존재하지 않습니다.
		if(null == member){
			view 
				= request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "아이디가 존재하지 않습니다.");
			view.forward(request, response);
		}else{
			if(pwd.equals(member.getPassword())){
				HttpSession session = request.getSession();
				session.setAttribute("user", member);
				response.sendRedirect("index.jsp");
			}else{
				//2. 비밀번호가 틀렸습니다.
				view 
				= request.getRequestDispatcher("views/common/errorPage.jsp");
				request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
				view.forward(request, response);
			}
		}
		
		
		
		//비지니스 로직 호출
//		MemberVo member = new MemberService().login(id, pwd);
//		//System.out.println(member.toString());
//		if(member != null){
//			//로그인 성공
//			HttpSession session = request.getSession();
//			session.setAttribute("user", member);
//			response.sendRedirect("index.jsp");
//		}else{
//			//로그인 실패
//			//로그인에 실패하셧습니다.
//			request.setAttribute("msg", "로그인에 실패하셧습니다!!");
//			RequestDispatcher view 
//					= request.getRequestDispatcher("views/common/errorPage.jsp");
//			view.forward(request, response);
//		}
	}
}











