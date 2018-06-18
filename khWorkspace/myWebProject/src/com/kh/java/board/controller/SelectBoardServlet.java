package com.kh.java.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.service.CommentService;
import com.kh.java.board.model.vo.BoardVo;
import com.kh.java.board.model.vo.CommentVo;

/**
 * Servlet implementation class SelectBoardServlet
 */
@WebServlet("/selectBoard.do")
public class SelectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//게시글에 대한 정보 조회 
		BoardVo board = new BoardService().selectBoard(boardNo);
		
		//댓글에 대한 정보 조회 
		ArrayList<CommentVo> cList 
				= new CommentService().selectCommentList(boardNo); 
		
		String url = "";
		
		if(null != board) {
			url = "views/board/boardDetail.jsp";
			
			//조회수를 가져오는 시간을 기다리지 않기 위한 방법.
			board.setCount(board.getCount() + 1 );
			request.setAttribute("board", board);
			request.setAttribute("cList", cList);
			request.setAttribute("currentPage", currentPage);
			
		}else {
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세 조회에 실패하였습니다.");
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
		
	}

}
