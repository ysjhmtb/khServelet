package com.kh.java.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.java.common.JDBCTemplate;
import com.kh.java.notice.model.dao.NoticeDao;
import com.kh.java.notice.model.vo.NoticeVo;


public class NoticeService {
	public List<NoticeVo> getNoticeList() {
		//커넥션을 맺는 역할 -> 서비스.
		// 	-> 트랜잭션 처리를 해야 하기 때문에.
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<NoticeVo> list = new NoticeDao().selectNoticeList(con);
		
		JDBCTemplate.close(con);
		
		return list;
		
		
	}
	
	public NoticeVo getNotice(int noticeNo) {
		
		Connection con = JDBCTemplate.getConnection();
		NoticeVo notice = new NoticeDao().selectNotice(con, noticeNo);
		JDBCTemplate.close(con);
		
		return notice;
	}
	
	public NoticeVo getNoticeOne() {
		//select
		
		
		//update -> 조회수 +1
		
		return new NoticeVo();
		
		
	}
	
	public ArrayList<NoticeVo> searchNotice(int condition, String keyword){
		//커넥션 생성.
		Connection con = JDBCTemplate.getConnection();
		
		//비지니스 로직.(dao 해당 기능 호출.)
		ArrayList<NoticeVo> list = new NoticeDao().selectNoticeKeyword(con, condition, keyword);
		
		//close
		JDBCTemplate.close(con);
		
		
		//return
		return list;
	}

}
