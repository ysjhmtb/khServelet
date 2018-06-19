package com.kh.java.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.java.board.model.vo.BoardVo;
import com.kh.java.board.model.vo.CommentVo;
import com.kh.java.common.JDBCTemplate;

public class CommentDao {

	public ArrayList<CommentVo> selectCommentList(Connection con, int boardNo) {
		ArrayList<CommentVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 작성
			query = "SELECT CNO, BNO, CCONTENT, CWRITER, CDATE, DELFLAG, USERNAME "
						+ "FROM BOARD_COMMENT "
						+ "JOIN MEMBER ON (CWRITER = USERID) "
						+ "WHERE BNO = ?";
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setInt(1, boardNo);
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultSet-list parsing)
			list = new ArrayList<CommentVo>();
			CommentVo temp = null;
			while(rs.next()){
				temp = new CommentVo();
				temp.setCno(rs.getInt("cno"));
				temp.setBno(boardNo);
				temp.setContent(rs.getString("ccontent"));
				temp.setWriter(rs.getString("cwriter"));
				temp.setWriterNm(rs.getString("username"));
				temp.setWriteDate(rs.getDate("cdate"));
				String flag = rs.getString("delflag");
				temp.setDelFlag(flag.equals("N") ? false : true);
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//7. 결과 리턴
		return list;
	}

	public int insertComment(Connection con, CommentVo comment) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		//0. 쿼리 작성(쿼리 틀)
		query = "INSERT INTO BOARD_COMMENT "
					+ "VALUES (SEQ_COMMENT.NEXTVAL, ?, ?, ?, DEFAULT, DEFAULT)";
		try {
			//1. 쿼리 전송 객체 생성(preparedstmt)
			pstmt = con.prepareStatement(query);
			//2. 쿼리 파라미터 설정
			pstmt.setInt(1, comment.getBno());
			pstmt.setString(2, comment.getContent());
			pstmt.setString(3, comment.getWriter());
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

	public int updateComment(Connection con, CommentVo comment) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		//0. 쿼리 작성(쿼리 틀)
		query = "UPDATE BOARD_COMMENT "
					+ "SET CCONTENT = ? "
					+ "WHERE CNO = ?";
		try {
			//1. 쿼리 전송 객체 생성(preparedstmt)
			pstmt = con.prepareStatement(query);
			//2. 쿼리 파라미터 설정
			pstmt.setString(1, comment.getContent());
			pstmt.setInt(2, comment.getCno());
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
}
