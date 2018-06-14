package com.kh.java.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.java.board.model.dao.BoardDao;
import com.kh.java.board.model.vo.BoardVo;
import com.kh.java.common.JDBCTemplate;

public class BoardService {
	public ArrayList<BoardVo> selectBoardList(){
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		
		//2. dao 메소드 호출
		ArrayList<BoardVo> list = new BoardDao().selectBoardList(con);
		
		//3. 자원 반납
		JDBCTemplate.close(con);
		
		return list;
	}

	public int insertBoard(BoardVo board) {
		Connection con = JDBCTemplate.getConnection();
		int result = new BoardDao().insertBoard(con, board);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		return result;
	}

	public BoardVo selectBoard(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		BoardVo board = new BoardDao().selectBoard(con, boardNo);
		
		
		//조회수 1 증가 구현 필요 
		if(null != board) {
			int result = new BoardDao().updateBoardCount(con, boardNo);
			
			if(0 < result) {
				JDBCTemplate.commit(con);
			}else {
				JDBCTemplate.rollback(con);
			}
		}
		
		JDBCTemplate.close(con);
		
		return board;
	}
	
	
	
}
