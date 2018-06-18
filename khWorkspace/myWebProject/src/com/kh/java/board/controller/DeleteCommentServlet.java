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
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/deleteComment.do")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCommentServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송값에 대한 한글 처리 
		request.setCharacterEncoding("UTF-8");
		
		//전송값 변수에 저장 
		int cno = Integer.parseInt(request.getParameter("cno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		CommentVo comment = new CommentVo();
		comment.setCno(cno);
		
		//비지니스 로직 호출 
		int result = new CommentService().deleteComment(comment);
		
		//화면 설정 
		if(0 < result) {
			response.sendRedirect("/mwp/boardList.do?currentPage=1");
		
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "댓글 삭제에 실패하였습니다.");
			view.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
