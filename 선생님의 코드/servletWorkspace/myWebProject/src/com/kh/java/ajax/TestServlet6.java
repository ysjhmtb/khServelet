package com.kh.java.ajax;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.java.member.model.vo.MemberVo;

@WebServlet("/test6.do")
public class TestServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet6() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo mv1 = new MemberVo("userid1", "이름1", 20);
		MemberVo mv2 = new MemberVo("userid2", "이름2", 25);
		MemberVo mv3 = new MemberVo("userid3", "이름3", 30);
		MemberVo mv4 = new MemberVo("userid4", "이름4", 31);
		MemberVo mv5 = new MemberVo("userid5", "이름5", 32);
		MemberVo mv6 = new MemberVo("userid6", "이름6", 33);
		MemberVo mv7 = new MemberVo("userid7", "이름7", 34);
		MemberVo mv8 = new MemberVo("userid8", "이름8", 35);
		MemberVo mv9 = new MemberVo("userid9", "이름9", 36);
		MemberVo mv10 = new MemberVo("userid10", "이름10", 40);
		list.add(mv1);
		list.add(mv2);
		list.add(mv3);
		list.add(mv4);
		list.add(mv5);
		list.add(mv6);
		list.add(mv7);
		list.add(mv8);
		list.add(mv9);
		list.add(mv10);
		
		int userIndex = Integer.parseInt(request.getParameter("index"));
		
		JSONArray resultList = new JSONArray();
		JSONObject tempVo = null;
		MemberVo temp = null;
		if(0 <= userIndex && userIndex < list.size()){
			temp = list.get(userIndex);
			tempVo = new JSONObject();
			tempVo.put("userId", temp.getUserId());
			tempVo.put("username", URLEncoder.encode(temp.getUserName(),"UTF-8"));
			tempVo.put("age", temp.getAge());
			
			resultList.add(tempVo);
		}else{
			for(MemberVo member : list){
				tempVo = new JSONObject();
				tempVo.put("userId", member.getUserId());
				tempVo.put("username", URLEncoder.encode(member.getUserName(),"UTF-8"));
				tempVo.put("age", member.getAge());
				
				resultList.add(tempVo);
			}
		}
		response.setContentType("application/json");
		response.getWriter().print(resultList.toJSONString());
	}
}








