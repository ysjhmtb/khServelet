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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//한글값 인코딩 처리.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//전송값 변수에 저장.
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone1") +"-"+
						request.getParameter("phone2")+"-"+
						request.getParameter("phone3");
		String address = request.getParameter("zipcode")+","+
						request.getParameter("address1")+","+
						request.getParameter("address2");
		String hobby = String.join(", ",request.getParameterValues("hobby"));
		
		MemberVo member = new MemberVo(id,pwd,userName,gender.charAt(0),
								age,email,phone,address,hobby);
		
		System.out.println(member.toString());
		
		//비지니스 로직 호출.
		MemberService ms = new MemberService();
		int result = ms.setMemberInfo(member);
		
		
		//해당 결과에 따른 return 페이지 설정.
		if(result > 0) {
			//DB의 값만 변경됐지 session의 값은 변경되지 않았다. session에 들어있던 값을 변경해야 한다.
			HttpSession session = request.getSession();
			session.setAttribute("msg",member);
			
			
			//회원 정보 수정 완료 -> 인덱스 페이지로 이동. 모든 서블릿은 웹루트에 존재.
			response.sendRedirect("index.jsp");
			
			
		}
		else {
			//에러 페이지 -> 회원 정보 수정 시 오류 발생.
			RequestDispatcher view 
				= request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "회원정보 수정시 오류 발생.");
			view.forward(request, response);
			
		}
	}

}








