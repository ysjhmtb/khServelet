package com.kh.java.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.BoardVo;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/writeBoard.do")
public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WriteBoardServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파일 업로드/다운로드 -> cos.jar 
		//1. 파일 사이즈 설정
		int maxSize = 1024 * 1024 * 10;
		//2. 파일 전송 시 enctype 정상적으로 설정 되었는지 확인
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)){
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "전송 데이터의 타입을 확인하십시오!!");
			view.forward(request, response);
		}
		//3. 파일 저장 경로 설정
		String root = request.getServletContext().getRealPath("/");
		System.out.println(root);
		String path = root + "upload";
		//4. request -> multipartrequest
		MultipartRequest mRequest = new MultipartRequest(request,
																		path, maxSize, "UTF-8");
		//전송 값을 변수에 저장
		String writer = mRequest.getParameter("writer");
		String title = mRequest.getParameter("title");
		String content = mRequest.getParameter("content");
		String fileName = mRequest.getFilesystemName("attFile");
		
		BoardVo board = new BoardVo();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		board.setAttachFile(fileName);

		//비지니스 호출
		int result = new BoardService().insertBoard(board);
		
		if(0 < result){
			response.sendRedirect("/mwp/boardList.do");
		}else{
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "게시글 작성에 실패하였습니다.");
			view.forward(request, response);
		}
	}
}











