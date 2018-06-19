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

@WebServlet("/deleteComment.do")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCommentServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
