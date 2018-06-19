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

/**
 * Servlet implementation class NoticePopupServlet
 */
@WebServlet("/noticePopup.do")
public class NoticePopupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NoticePopupServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가장 최신 공지사항을 조회 후 팝업.jsp에 return
		NoticeVo notice = new NoticeService().getNoticeLast();
		
		RequestDispatcher view = null;
		if(notice != null){
			view = request.getRequestDispatcher("views/common/noticePopup.jsp");
			request.setAttribute("notice", notice);
		}else{
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "팝업 데이터를 조회하는데 실패하였습니다.");
		}
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}












