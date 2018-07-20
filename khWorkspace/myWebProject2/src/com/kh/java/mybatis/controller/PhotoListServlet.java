package com.kh.java.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.mybatis.model.service.MybatisService;
import com.kh.java.mybatis.model.vo.Photo;


@WebServlet("/photoList.do")
public class PhotoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PhotoListServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Photo> list = new MybatisService().selectPhotoList();
		System.out.println(list);
		
		RequestDispatcher view = request.getRequestDispatcher("views/mybatis/photoList.jsp");
		request.setAttribute("list", list);
		view.forward(request, response);
		
	}

}
