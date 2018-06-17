package com.kh.java.board.model.service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.kh.java.board.model.service.BoardService;

public class BoardServiceTest {

	@Test
	public void testDeleteBoard() {
		BoardService test = new BoardService();
		int boardNo = 63;
		assertNotNull(test.deleteBoard(boardNo));
	}

}
