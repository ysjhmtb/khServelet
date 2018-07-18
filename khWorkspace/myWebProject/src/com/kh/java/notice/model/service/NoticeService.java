package com.kh.java.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.common.JDBCTemplate;
import com.kh.java.common.MySqlFactory;
import com.kh.java.notice.model.dao.NoticeDao;
import com.kh.java.notice.model.dao.NoticeDaoPstmt;
import com.kh.java.notice.model.vo.NoticeVo;


public class NoticeService {
	
	
	//기존 statement 적용
	//NoticeDao noticeDao = new NoticeDao();
	//preparedStatement 적용
	NoticeDaoPstmt noticeDao = new NoticeDaoPstmt();
	
	public List<NoticeVo> getNoticeList() {
		
				//~~~~Factory - Factory 패턴 -> 객체를 생성 하실때 
				//커넥션을 맺는 역할 -> 서비스 
				//	-> 트랜젝션 관리를 해야 하기 때문에
//				Connection con = JDBCTemplate.getConnection();
//				ArrayList<NoticeVo> list = noticeDao.selectNoticeList(con);
//				JDBCTemplate.close(con);
//				return list;
				
				//openSession - parameter - autocommit에 대한 설정 여부
				SqlSession session = MySqlFactory.getSqlSession().openSession(false);
				List<NoticeVo> list = noticeDao.selectNoticeList(session);
				session.close();
				return list;
		
	}
	
	public NoticeVo getNotice(int noticeNo) {
		
		Connection con = JDBCTemplate.getConnection();
		NoticeVo notice = new NoticeDao().selectNotice(con, noticeNo);
		
		if(null != notice) {
			int result = new NoticeDao().updateNoticeCount(con, noticeNo);
			
			if(0 < result) {
				JDBCTemplate.commit(con);
				
			}else {
				JDBCTemplate.rollback(con);
			}
		}
		
		
		
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

	public int writeNotice(NoticeVo notice) {
		//커넥션을 생성.
		Connection con = JDBCTemplate.getConnection();
		
		//비지니스 로직 호출.
		int result = new NoticeDao().insertNotice(con,notice);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		//자원 반납. close
		JDBCTemplate.close(con);
		
		//결과 반환.
		return result;
	}

	public NoticeVo getNoticeFormData(int noticeNo) {
		Connection con = JDBCTemplate.getConnection();
		NoticeVo notice = new NoticeDao().selectNotice(con, noticeNo);
		JDBCTemplate.close(con);
		return notice;
	}

	public int modifyNotice(NoticeVo notice) {
		//1. 커넥션 생성.
		Connection con = JDBCTemplate.getConnection();
		
		//2. dao 호출.
		int result = new NoticeDao().updateNotice(con,notice);
		
		//3. 트랜잭션 처리.
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		//4. 자원 반납.
		JDBCTemplate.close(con);
				
		//5. return
		return result;
		
		
	}

	public int removeNotice(int noticeNo) {
		//1. 커넥션 생성.
		Connection con = JDBCTemplate.getConnection();
		
		//2. dao 호출.
		int result = new NoticeDao().deleteNotice(con,noticeNo);
		
		//3. 트랜잭션 처리.
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		//4. 자원 반납.
		JDBCTemplate.close(con);
				
		//5. return
		return result;
	}

	
	public NoticeVo getNoticeLast() {
		Connection con = JDBCTemplate.getConnection();
		NoticeVo notice = new NoticeDao().selectNoticeLast(con);
		JDBCTemplate.close(con);
		return notice;
	}

}




