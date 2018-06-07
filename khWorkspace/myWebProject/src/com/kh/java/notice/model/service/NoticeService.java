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
	
	public NoticeVo getNoticeOne() {
		//select
		
		
		//update -> 조회수 +1
		
		
	}

}
