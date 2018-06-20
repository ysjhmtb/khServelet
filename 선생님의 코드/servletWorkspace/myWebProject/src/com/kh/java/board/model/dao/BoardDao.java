package com.kh.java.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.java.board.model.vo.BoardVo;
import com.kh.java.common.JDBCTemplate;

public class BoardDao {
	public ArrayList<BoardVo> selectBoardList(Connection con){
		ArrayList<BoardVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 전송 객체 생성
			stmt = con.createStatement();
			//2. 쿼리 작성
			query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
						+ "FROM BOARD B, MEMBER M "
						+ "WHERE B.BWRITER = M.USERID "
						+ "ORDER BY BNO DESC ";
			//3. 쿼리 실행
			rs = stmt.executeQuery(query);
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			while(rs.next()){
				temp = new BoardVo();
				temp.setNo(rs.getInt("bno"));
				temp.setTitle(rs.getString("btitle"));
				temp.setContent(rs.getString("bcontent"));
				temp.setWriter(rs.getString("bwriter"));
				temp.setWriterName(rs.getString("username"));
				temp.setCount(rs.getInt("bcount"));
				temp.setWriteDate(rs.getDate("bdate"));
				temp.setAttachFile(rs.getString("boardfile"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		//6. 결과 리턴
		return list;
	}

	public int insertBoard(Connection con, BoardVo board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		//0. 쿼리 작성(쿼리 틀)
		query = "INSERT INTO BOARD "
					+ "VALUES (SEQ_BOARD.NEXTVAL, ?, ?, ?, DEFAULT, "
					+ " ?, DEFAULT, DEFAULT)";
		try {
			//1. 쿼리 전송 객체 생성(preparedstmt)
			pstmt = con.prepareStatement(query);
			//2. 쿼리 파라미터 설정
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getAttachFile());
			//3. 쿼리 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//4. 자원 반납
			JDBCTemplate.close(pstmt);
		}
		//5. 결과 리턴
		return result;
	}

	public BoardVo selectBoard(Connection con, int boardNo) {
		BoardVo board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		//1. 쿼리 작성
		query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+ "FROM BOARD B, MEMBER M "
					+ "WHERE B.BWRITER = M.USERID "
					+ " AND BNO = ?";
		try {
			//2. 쿼리 실행 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 파라미터 설정
			pstmt.setInt(1, boardNo);
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultset)
			while(rs.next()){
				board = new BoardVo();
				board.setTitle(rs.getString("BTITLE"));
				board.setContent(rs.getString("BCONTENT"));
				board.setNo(boardNo);
				board.setCount(rs.getInt("BCOUNT"));
				board.setWriter(rs.getString("BWRITER"));
				board.setWriterName(rs.getString("USERNAME"));
				board.setWriteDate(rs.getDate("BDATE"));
				board.setAttachFile(rs.getString("BOARDFILE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 자원 반납
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//7. 결과 값 return
		return board;
	}

	public int updateBoard(Connection con, BoardVo board) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE BOARD "
					+ "SET BTITLE = ?, BCONTENT = ?, BOARDFILE = ? "
					+ "WHERE BNO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getAttachFile());
			pstmt.setInt(4, board.getNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateBoardCount(Connection con, int boardNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE BOARD "
					+ "SET BCOUNT = BCOUNT + 1 "
					+ "WHERE BNO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int selectBoardTotalCount(Connection con) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "
						+ "FROM BOARD "
						+ "WHERE DELFLAG != 'Y' ";
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				result = rs.getInt("listcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public ArrayList<BoardVo> selectBoardListPage(Connection con, int currentPage, int limit) {
		ArrayList<BoardVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+ "FROM ( SELECT ROWNUM RNUM, P.* "
					+				"FROM (SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+						"   FROM BOARD B, MEMBER M "
					+						"   WHERE B.BWRITER = M.USERID "
					+						"   	AND B.DELFLAG = 'N' "
					+ 						"   ORDER BY BNO DESC) P) "
					+ "WHERE RNUM BETWEEN ? AND ? ";

			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			while(rs.next()){
				temp = new BoardVo();
				temp.setNo(rs.getInt("bno"));
				temp.setTitle(rs.getString("btitle"));
				temp.setContent(rs.getString("bcontent"));
				temp.setWriter(rs.getString("bwriter"));
				temp.setWriterName(rs.getString("username"));
				temp.setCount(rs.getInt("bcount"));
				temp.setWriteDate(rs.getDate("bdate"));
				temp.setAttachFile(rs.getString("boardfile"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴
		return list;
	}

	public int selectBoardTotalCountSearch(Connection con, int condition, String keyword) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "
						+ "FROM BOARD "
						+ "WHERE DELFLAG != 'Y' "
						+ " AND BTITLE LIKE '%" + keyword + "%'";
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				result = rs.getInt("listcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public ArrayList<BoardVo> selectBoardListPageSearch(Connection con, int currentPage, int limit, int condition,
			String keyword) {
		ArrayList<BoardVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+ "FROM ( SELECT ROWNUM RNUM, P.* "
					+				"FROM (SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
					+						"   FROM BOARD B, MEMBER M "
					+						"   WHERE B.BWRITER = M.USERID "
					+						"		AND B.BTITLE LIKE '%' || ? || '%' "	
					+ 						"   ORDER BY BNO DESC) P) "
					+ "WHERE RNUM BETWEEN ? AND ? ";

			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, keyword);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			while(rs.next()){
				temp = new BoardVo();
				temp.setNo(rs.getInt("bno"));
				temp.setTitle(rs.getString("btitle"));
				temp.setContent(rs.getString("bcontent"));
				temp.setWriter(rs.getString("bwriter"));
				temp.setWriterName(rs.getString("username"));
				temp.setCount(rs.getInt("bcount"));
				temp.setWriteDate(rs.getDate("bdate"));
				temp.setAttachFile(rs.getString("boardfile"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴
		return list;
	}

	public int deleteBoard(Connection con, int boardNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "UPDATE BOARD "
					+ "SET DELFLAG = 'Y' "
					+ "WHERE BNO = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	
}











