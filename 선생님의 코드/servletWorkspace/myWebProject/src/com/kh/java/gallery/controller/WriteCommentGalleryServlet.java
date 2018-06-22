package com.kh.java.gallery.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.java.board.model.service.CommentService;
import com.kh.java.board.model.vo.CommentVo;

@WebServlet("/writeCommentGallery.do")
public class WriteCommentGalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WriteCommentGalleryServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int bno = Integer.parseInt(request.getParameter("bno"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		CommentVo comment = new CommentVo(bno, content, writer);
		//비지니스 로직 호출
		int result = new CommentService().insertComment(comment);
		//댓글에 대한 정보 조회
		ArrayList<CommentVo> cList 
							= new CommentService().selectCommentList(bno);
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(cList, response.getWriter());
	}
}






