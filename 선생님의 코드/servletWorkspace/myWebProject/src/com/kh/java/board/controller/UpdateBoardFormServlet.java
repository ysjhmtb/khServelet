package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.BoardVo;

@WebServlet("/updateBoardForm.do")
public class UpdateBoardFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBoardFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		BoardVo board = new BoardService().selectBoardForm(boardNo);
		
		String url = "";
		if(null != board){
			url = "views/board/boardUpdateForm.jsp";
			request.setAttribute("board", board);
		}else{
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 수정 페이지로 이동 실패!!");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}
}












