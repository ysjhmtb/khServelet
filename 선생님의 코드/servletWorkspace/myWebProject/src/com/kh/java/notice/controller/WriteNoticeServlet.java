package com.kh.java.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.notice.model.service.NoticeService;
import com.kh.java.notice.model.vo.NoticeVo;

@WebServlet("/writeNotice.do")
public class WriteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WriteNoticeServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 인코딩
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//전송 값 변수에 저장
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeVo notice = new NoticeVo(writer, title, content);
		
		//비지니스 로직 호출
		int result = new NoticeService().writeNotice(notice);
		
		//결과 처리(응답 페이지 설정)
		RequestDispatcher view = null;
		if(0 < result){
			view = request.getRequestDispatcher("views/notice/noticeList.jsp");
			request.setAttribute("list", new NoticeService().getNoticeList());
		}else{
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "공지사항 작성 중 오류가 발생하였습니다.");
		}
		view.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}








