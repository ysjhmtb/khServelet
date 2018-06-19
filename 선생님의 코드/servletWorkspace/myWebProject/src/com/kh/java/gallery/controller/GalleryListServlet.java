package com.kh.java.gallery.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.gallery.model.service.GalleryService;
import com.kh.java.gallery.model.vo.AttachmentVo;

@WebServlet("/galleryList.do")
public class GalleryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GalleryListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AttachmentVo> list = 
				new GalleryService().selectGalleryList();
		
		String url = "";
		if(null != list){
			url = "views/gallery/galleryList.jsp";
			request.setAttribute("list", list);
		}else{
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 게시판 목록 조회 실패!!");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}

}











