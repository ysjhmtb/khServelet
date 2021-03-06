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


@WebServlet("/noticeDetail.do")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NoticeDetailServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		NoticeVo notice = new NoticeService().getNotice(noticeNo);
		System.out.println(notice);
		
		
		//조회 성공 -> 해당 detail view로 이동.
		//성능을 위해서 null과 같은 고정값을 비교구문 앞에 위치.
		RequestDispatcher view = null;
		if(null != notice) {
			request.setAttribute("notice", notice);
			view = request.getRequestDispatcher("views/notice/noticeDetail.jsp");
			
		}else {
			
			//조회 실패 -> 에러페이지 -> 공지사항 불러오기 실패!
			request.setAttribute("msg", "공지사항 상세보기 실패.");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
		}
		
		view.forward(request, response);
		
		
	}

}
