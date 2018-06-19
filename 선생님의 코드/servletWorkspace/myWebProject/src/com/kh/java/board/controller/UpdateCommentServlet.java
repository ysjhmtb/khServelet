package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.CommentService;
import com.kh.java.board.model.vo.CommentVo;

@WebServlet("/updateComment.do")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCommentServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int cno = Integer.parseInt(request.getParameter("cno"));
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));
		CommentVo comment = new CommentVo();
		comment.setCno(cno);
		comment.setContent(content);
		
		int result = new CommentService().updateComment(comment);
		
		if(0 < result){
			response.sendRedirect("/mwp/selectBoard.do?boardNo="+bno+"&currentPage=1");
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "댓글 수정 실패!!");
			view.forward(request, response);
		}
	}
}






