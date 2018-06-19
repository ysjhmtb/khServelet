package com.kh.java.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LoginWrapper extends HttpServletRequestWrapper {
	public LoginWrapper(HttpServletRequest request){
		//원본 request객체를 부모 필드에 저장
		super(request);
	}

	@Override
	public String getParameter(String name) {
		//특정 필드(pwd)에 대해서 값 변경 처리
		if(null != name && "pwd".equals(name)){
			return super.getParameter(name) + "//값 변경 됨";
		}else{
			return super.getParameter(name);
		}
	}
}





