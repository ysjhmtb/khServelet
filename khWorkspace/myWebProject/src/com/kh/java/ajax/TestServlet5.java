package com.kh.java.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.MemberVo;

/**
 * Servlet implementation class TestServlet5
 */
@WebServlet("/test5.do")
public class TestServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = "admin";
		MemberVo member = new MemberService().getMemberId(id);
		
		JSONObject result = new JSONObject();
		result.put("id", member.getUserId());
		
		
		/*
			윈도우에서는 
			
			result.put("age", member.getAge() + "");
			response.setContentType("application/json; charset=utf-8");
			
			이와 같아야 한다.
			
		 */
		
		
		result.put("age", member.getAge());
		result.put("email", member.getEmail());
		result.put("addr", member.getAddress());
		
		response.setContentType("application/json");
		response.getWriter().print(result.toJSONString());
		
	}

}
