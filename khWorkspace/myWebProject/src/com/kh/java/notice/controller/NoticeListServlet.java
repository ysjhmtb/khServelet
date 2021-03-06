package com.kh.java.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.java.notice.model.service.NoticeService;
import com.kh.java.notice.model.vo.NoticeVo;

@WebServlet("/noticeList.do")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NoticeListServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글 전송값이 존재할 경우 인코딩 처리.
		//전송값이 없기 때문에 인코딩 처리 불필요.
		
		//2.전송값 변수에 저장.
		//변수 저장도 불필요.
		
		//3.비지니스 로직 호출.(서비스 호출)
		//공지사항의 목록을 조회.
		
		
		List<NoticeVo> list = new NoticeService().getNoticeList();
		System.out.println(list);
		
		for(NoticeVo vo : list) {
			System.out.println(vo.toString());
		}
		
		//4.로직 결과 처리.(응답 페이지 처리)
		RequestDispatcher view = null;
		
		if(list.size() != 0) {
			//조회 성공 -> 공지사항 페이지 목록 출력.
			request.setAttribute("list", list);
			view = request.getRequestDispatcher("views/notice/noticeList.jsp");
			
			
		}else {
			// 조회 실패 -> 에러 페이지 -> 공지사항 불러오기를 실패하셨습니다.
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "공지사항 불러오기를 실패하였습니다.");
			
			
		}
		
		// if와 else 모두에서 forward를 사용하므로 하나만 사용하도록 이곳에 위치.
		view.forward(request, response);
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
