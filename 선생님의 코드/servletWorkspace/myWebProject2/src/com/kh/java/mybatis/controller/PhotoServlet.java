package com.kh.java.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.mybatis.model.service.MybatisService;
import com.kh.java.mybatis.model.vo.Photo;

@WebServlet("/selectPhoto.do")
public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PhotoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		HashMap<String, String> params =
				new HashMap<String, String>();
		params.put("no", no);
		
		Photo photo = new MybatisService().selectPhoto(params);
		System.out.println(photo);
		
		RequestDispatcher view = request.getRequestDispatcher("views/mybatis/photoPage.jsp");
		request.setAttribute("photo", photo);
		view.forward(request, response);
	}

}
