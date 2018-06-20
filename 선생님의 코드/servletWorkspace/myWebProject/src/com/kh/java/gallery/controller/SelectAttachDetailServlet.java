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

@WebServlet("/selectAttachDetail.do")
public class SelectAttachDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectAttachDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		ArrayList<AttachmentVo> list = new GalleryService().selectGallery(bno);
		
		String url = "";
		if(list != null){
			url = "views/gallery/galleryDetail.jsp";
			request.setAttribute("list", list);
		}else{
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "이미지 게시판 상세보기에 실패하였습니다.");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
