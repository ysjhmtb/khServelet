package com.kh.java.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.java.common.JDBCTemplate;
import com.kh.java.notice.model.dao.NoticeDao;
import com.kh.java.notice.model.vo.NoticeVo;

public class NoticeService {
	public List<NoticeVo> getNoticeList(){
		//커넥션을 맺는 역할 -> 서비스 
		//	-> 트랜젝션 관리를 해야 하기 때문에
		Connection con = JDBCTemplate.getConnection();
		ArrayList<NoticeVo> list = new NoticeDao().selectNoticeList(con);
		JDBCTemplate.close(con);
		return list;
	}
	public NoticeVo getNotice(int noticeNo){
		Connection con = JDBCTemplate.getConnection();
		
		NoticeVo notice = new NoticeDao().selectNotice(con, noticeNo);
		
		if(null != notice){
			int result = new NoticeDao().updateNoticeCount(con, noticeNo);
			if(0 < result){
				JDBCTemplate.commit(con);
			}else{
				JDBCTemplate.rollback(con);
			}
		}
		
		JDBCTemplate.close(con);
		return notice;
	}
	public ArrayList<NoticeVo> searchNotice(int condition, String keyword) {
		//커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//비지니스 로직(dao 해당 기능 호출)
		ArrayList<NoticeVo> list = 
				new NoticeDao().selectNoticeKeyword(con, condition, keyword);
		//close
		JDBCTemplate.close(con);
		//return
		return list;
	}
	public int writeNotice(NoticeVo notice) {
		//커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//비지니스 로직 호출
		int result = new NoticeDao().insertNotice(con, notice);
		//트랜젝션 처리
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		//자원 반납(close)
		JDBCTemplate.close(con);
		//결과 반환
		return result;
	}
	public NoticeVo getNoticeFormData(int noticeNo) {
		Connection con = JDBCTemplate.getConnection();
		NoticeVo notice = new NoticeDao().selectNotice(con, noticeNo);
		JDBCTemplate.close(con);
		return notice;
	}
	public NoticeVo getLastNotice() {
		Connection con = JDBCTemplate.getConnection();
		NoticeVo notice = new NoticeDao().selectLastNotice(con);
		JDBCTemplate.close(con);
		return notice;
	}
	
	public int modifyNotice(NoticeVo notice){
		//1. 커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//2. dao 호출
		int result = new NoticeDao().updateNotice(con, notice);
		//3. 트랜젝션 처리
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		//4. 자원 반납(close)
		JDBCTemplate.close(con);
		//5. 해당 결과 return
		return result;
	}
	public int removeNotice(int noticeNo) {
		//1. 커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//2. dao 호출
		int result = new NoticeDao().deleteNotice(con, noticeNo);
		//3. 트랜젝션 처리
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		//4. 자원 반납(close)
		JDBCTemplate.close(con);
		//5. 해당 결과 return
		return result;
	}
	
	public NoticeVo getNoticeLast(){
		Connection con = JDBCTemplate.getConnection();
		NoticeVo notice = new NoticeDao().selectNoticeLast(con);
		JDBCTemplate.close(con);
		return notice;
	}
}













