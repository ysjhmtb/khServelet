package com.kh.java.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.board.model.service.BoardService;

/**
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet("/deleteBoard.do")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		String fileName = new BoardService().selectBoard(boardNo).getAttachFile();
		String path = "/Users/yunseokjeon/git/khServlet/khWorkspace/myWebProject/web/upload";
		if(fileName != null) {
			System.out.println(fileName);
			File file = new File(path + "/" + fileName);
			file.delete();
		}
		
		
		
		int result = new BoardService().deleteBoard(boardNo);
		
		RequestDispatcher view = null;
		
		if(0 < result) {
			response.sendRedirect("/mwp/boardList.do");
//			view = request.getRequestDispatcher("views/board/boardList.jsp");
//			request.setAttribute("list", new BoardService().selectBoardList());
			
		}else {
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "게시글 삭제에 실패하였습니다.");
			view.forward(request, response);
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
