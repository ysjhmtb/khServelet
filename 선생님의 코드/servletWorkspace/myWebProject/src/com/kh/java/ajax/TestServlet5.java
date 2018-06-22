package com.kh.java.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.java.member.model.service.MemberService;
import com.kh.java.member.model.vo.MemberVo;

@WebServlet("/test5.do")
public class TestServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet5() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = "admin";
		MemberVo member = new MemberService().getMemberId(id);
		
		JSONObject result = new JSONObject();
		result.put("id", member.getUserId());
		result.put("age", member.getAge());
		result.put("email", member.getEmail());
		result.put("gender", member.getGender() + "");
		result.put("addr", member.getAddress());
		
		response.setContentType("application/json");
		response.getWriter().print(result.toJSONString());
	}
}








