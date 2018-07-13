package com.matajo.pitpet.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matajo.pitpet.board.model.vo.BoardVo;


/**
 * Servlet implementation class BoardFilterServlet
 */
@WebServlet("/BoardFilter.do")
public class BoardFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchService = request.getParameter("searchService");
		String searchPet = request.getParameter("searchPet");
		String searchGrade = request.getParameter("searchGrade");
		int min_p;
		int max_p;
		

		System.out.println(searchService);
		System.out.println(searchPet);
		System.out.println(searchGrade);
		
		if(request.getParameter("min_p")!=null||request.getParameter("max_p")!=null){
		min_p = Integer.parseInt(request.getParameter("min_p"));
		max_p = Integer.parseInt(request.getParameter("max_p"));
		System.out.println(min_p);
		System.out.println(max_p);
		}
		
		
		BoardVo board = new BoardVo();
//		board.setWriter(writer);
//		board.setTitle(title);
//		board.setContent(content);
//		board.setAttachFile(fileName);

		
	}

	

}
