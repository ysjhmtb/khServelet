package com.kh.java.member.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login.dd")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//래퍼 클래스의 생성자를 호출하기 위해 강제 형변환
		HttpServletRequest originRequest = (HttpServletRequest)request;
		//생성자를 호출하여 객체 생성
		LoginWrapper lw = new LoginWrapper(originRequest);
		//래퍼 객체를 서블릿으로 전달(다음 필터에 전달)
		chain.doFilter(lw, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}






