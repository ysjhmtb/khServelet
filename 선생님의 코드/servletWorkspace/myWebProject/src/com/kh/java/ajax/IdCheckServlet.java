package com.kh.java.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.MemberVo;

@WebServlet("/idCheck.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdCheckServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId"); 
		
		MemberVo member = new MemberService().getMemberId(id);
		
		String message = "";
		
		if(null != member){
			message = "해당 아이디는 사용하실수 없습니다.";
		}else{
			message = "사용가능한 아이디 입니다.";
		}
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(message);
	}
}











