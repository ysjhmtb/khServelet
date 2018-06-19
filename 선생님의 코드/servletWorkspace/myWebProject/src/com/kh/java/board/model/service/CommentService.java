package com.kh.java.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.java.board.model.dao.CommentDao;
import com.kh.java.board.model.vo.CommentVo;
import com.kh.java.common.JDBCTemplate;

public class CommentService {
	public ArrayList<CommentVo> selectCommentList(int boardNo){
		//connection 생성
		Connection con = JDBCTemplate.getConnection();
		//기능 호출
		ArrayList<CommentVo> list 
							= new CommentDao().selectCommentList(con, boardNo);
		//트랜젝션 처리
		JDBCTemplate.close(con);
		//결과 반환
		return list;
	}

	public int insertComment(CommentVo comment) {
		//커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//로직 호출
		int result = new CommentDao().insertComment(con, comment);
		//결과 처리(트랜젝션)
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		//자원 반납
		JDBCTemplate.close(con);
		//결과 return
		return result;
	}

	public int updateComment(CommentVo comment) {
		//커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//로직 호출
		int result = new CommentDao().updateComment(con, comment);
		//결과 처리(트랜젝션)
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		//자원 반납
		JDBCTemplate.close(con);
		//결과 return
		return result;
	}
}
















