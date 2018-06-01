package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.MemberVo;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
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
		
		//서비스 호출. 
		MemberService ms = new MemberService();
		
		int result = ms.joinMember(member);
		
		
		
		
		
		
		
	}

}
