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

@WebServlet("/updateNoticeForm.do")
public class UpdateNoticeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateNoticeFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		NoticeVo result = new NoticeService().getNoticeFormData(noticeNo);
		
		RequestDispatcher view = null;
		if(null != result){
			view = request.getRequestDispatcher("views/notice/noticeUpdateForm.jsp");
			request.setAttribute("notice", result);
		}else{
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "수정 페이지 이동 시 에러 발생!!");
		}
		view.forward(request, response);
	}
}









