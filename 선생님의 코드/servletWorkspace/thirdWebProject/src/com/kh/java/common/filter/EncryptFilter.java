package com.kh.java.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.java.common.wrapper.EncryptWrapper;

/**
 * Servlet Filter implementation class EncryptFilter
 */
@WebFilter("*.au")
public class EncryptFilter implements Filter {
    public EncryptFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest originRequest = (HttpServletRequest)request;
		request.setAttribute("originPwd", originRequest.getParameter("pwd"));
		EncryptWrapper ew = new EncryptWrapper(originRequest);
		chain.doFilter(ew, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}









