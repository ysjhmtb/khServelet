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

@WebServlet("/updateNotice.do")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateNoticeServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송 값 한글 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//2. 전송 값 변수에 저장
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		NoticeVo notice = new NoticeVo(noticeNo, title, content);
		//3. 비지니스 로직 호출
		int result = new NoticeService().modifyNotice(notice);
		
		//4. 해당 결과 화면 return
		RequestDispatcher view = null;
		if(0 < result){
			view = request.getRequestDispatcher("views/notice/noticeList.jsp");
			request.setAttribute("list", new NoticeService().getNoticeList());
		}else{
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "공지사항 수정에 실패하였습니다.");
		}
		view.forward(request, response);
	}
}
















