package com.kh.java.board.model.dao.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Test;

import com.kh.java.board.model.dao.BoardDao;
import com.kh.java.common.JDBCTemplate;

public class BoardDaoTest {

	@Test
	public void testDeleteBoard() {
		Connection con = JDBCTemplate.getConnection();
		BoardDao test = new BoardDao();
		int boardNo = 63;
		
		int result = test.deleteBoard(con, boardNo);
		assertEquals(result,1);
		
	}

}
