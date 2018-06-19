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

/**
 * Servlet implementation class WriteCommentServlet
 */
@WebServlet("/writeComment.do")
public class WriteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteCommentServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송 값에 대한 한글 처리
		request.setCharacterEncoding("utf-8");
		//전송 값 변수에 저장
		int bno = Integer.parseInt(request.getParameter("bno"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		CommentVo comment = new CommentVo(bno, content, writer);
		//비지니스 로직 호출
		int result = new CommentService().insertComment(comment);
		
		//화면 설정
		if(0 < result){
			response.sendRedirect("/mwp/selectBoard.do?boardNo="+bno+"&currentPage=1");
		}else{
			RequestDispatcher view 
					= request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "댓글 작성에 실패하셧습니다.");
			view.forward(request, response);
		}
	}
}













