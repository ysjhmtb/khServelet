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
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String fileName = request.getParameter("fileName");
		
		//기존 파일 삭제
		String root = request.getServletContext().getRealPath("/");
		String path = root + "upload";
		System.out.println(path + "/" + fileName);
		if(null != fileName){
			File file = new File(path + "/" + fileName);
			file.delete();
		}
		
		int result = new BoardService().deleteBoard(boardNo);
		
		if(0 < result){
			response.sendRedirect("/mwp/boardList.do");
		}else{
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "게시글 수정에 실패하였습니다.");
			view.forward(request, response);
		}
	}

}
