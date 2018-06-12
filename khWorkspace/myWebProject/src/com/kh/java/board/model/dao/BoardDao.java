package com.kh.java.board.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.java.board.model.vo.BoardVo;

public class BoardDao {
	
	/*
	 Statement - 실행할 쿼리가 100% 모두 작성되어 있었다.
	 
	 preparedStatement - 실행할 쿼리가 완벽하지 않다. 가변적인 부분이 빠져있다. 가변적인 부분을 ?로 남겨놓는다.
	 					쿼리를 실행하기 전에 ?에 들어갈 부분을 세팅한다.
	 					
	 					
	 */

	public ArrayList<BoardVo> selectBoardList(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

}
