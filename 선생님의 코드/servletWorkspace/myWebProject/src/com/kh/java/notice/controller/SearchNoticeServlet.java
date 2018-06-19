package com.kh.java.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.notice.model.service.NoticeService;
import com.kh.java.notice.model.vo.NoticeVo;

@WebServlet("/searchNotice.do")
public class SearchNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchNoticeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 전송 값에 한글이 있을 경우 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//2. 전송 값들 변수에 저장
		int condition = Integer.parseInt(request.getParameter("condition"));
		String keyword = request.getParameter("keyword");
		//3. 비지니스 로직 호출
		NoticeService ns = new NoticeService();
		ArrayList<NoticeVo> list = ns.searchNotice(condition, keyword);
		
		//4. 결과 처리(응답 페이지 설정)
		RequestDispatcher view = null;
		if(null != list){
			request.setAttribute("list", list);
			//검색어와 검색 조건 설정
			view = request.getRequestDispatcher("views/notice/noticeList.jsp");
		}else{
			request.setAttribute("msg", "공지사항 검색 중 오류 발생!!");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
	}
}












