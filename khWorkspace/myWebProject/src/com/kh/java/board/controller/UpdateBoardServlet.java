package com.kh.java.board.controller;

import java.io.File;
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

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateBoard.do")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 파일 업로드 다운로드 => cos.jar 라는 라이브러리를 사용하게 된다. http가 아닌 ftp를 사용하여 파일을 전송한다.
		// 엑셀 파일의 경우 poi.jar 사용.
		
		//1. 파일 사이즈 설정
		int maxSize = 1024 * 1024 * 10;
		
		//2. 파일 전송 시 enctype 정상적으로 설정되었는 확인
		RequestDispatcher view = null;
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "전송 데이터의 타입을 확인하십시오.");
			view.forward(request, response);
		}
		
		
		//3. 파일 저장 경로 설정.
//				String root = request.getServletContext().getRealPath("/"); 
//				System.out.println(root);
//				String path = root + "upload";
		String path = "/Users/yunseokjeon/git/khServlet/khWorkspace/myWebProject/web/upload";
		
		//4. request -> multipartrequest (cos.jar 역할)
		MultipartRequest mRequest 
			= new MultipartRequest(request, path, maxSize, "UTF-8");
		
		//변수에 값 저장
		int boardNo = Integer.parseInt(mRequest.getParameter("boardNo"));
		String title = mRequest.getParameter("title");
		String content = mRequest.getParameter("content");
		String fileName = mRequest.getFilesystemName("newFile");
		String oldFile = mRequest.getParameter("oldFile");
		
		
		
		//수정 파일의 존재 여부를 확인 -> 기존 파일 삭제 
		if(null != fileName) {
			System.out.println(fileName + " / " + oldFile);
			File file = new File(path + "/" + oldFile);
		
			file.delete();
			
		}
		
		BoardVo board = new BoardVo();
		board.setNo(boardNo);
		board.setTitle(title);
		board.setContent(content);
		board.setAttachFile(null != fileName ? fileName : oldFile);
		
		int result = new BoardService().updateBoard(board);
		
		String url = "";
		if(0 < result) {
			url = "views/board/boardDetail.jsp";
			board = new BoardService().selectBoardForm(boardNo);
			request.setAttribute("board", board);
		}else {
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 수정에 실패하였습니다.");
		}
		
		view = request.getRequestDispatcher(url);
		view.forward(request, response);
		
		
				
	}

}
