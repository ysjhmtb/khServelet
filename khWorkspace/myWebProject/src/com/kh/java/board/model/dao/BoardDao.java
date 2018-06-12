package com.kh.java.board.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.java.board.model.vo.BoardVo;
import com.kh.java.common.JDBCTemplate;

public class BoardDao {
	
	/*
	 Statement - 실행할 쿼리가 100% 모두 작성되어 있었다.
	 
	 preparedStatement - 실행할 쿼리가 완벽하지 않다. 가변적인 부분이 빠져있다. 가변적인 부분을 ?로 남겨놓는다.
	 					쿼리를 실행하기 전에 ?에 들어갈 부분을 세팅한다.
	 					
	 					
	 */

	public ArrayList<BoardVo> selectBoardList(Connection con) {
		ArrayList<BoardVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		
		
		try {
			//1. 쿼리 전송 객체 생성
			stmt = con.createStatement();
			
			//2. 쿼리 작성
			query = "SELECT BNO, BTITLE," + 
					"BCONTENT, BWRITER," + 
					"BCOUNT, BDATE, DELFLAG " + 
					"FROM BOARD B, MEMBER M " + 
					"WHERE B.BWRITER = M.USERID";
			
			//3. 쿼리 실행
			rs = stmt.executeQuery(query);
			
			//4. 결과 처리 - 파싱
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			
			while(rs.next()) {
				temp = new BoardVo();
				temp.setNo(rs.getInt("bno"));
				temp.setTitle(rs.getString("btitle"));
				temp.setContent(rs.getString("bcontent"));
				temp.setWriter(rs.getString("bwriter"));
				temp.setWriterName(rs.getString("username"));
				temp.setCount(rs.getInt("bcount"));
				temp.setWriteDate(rs.getDate("bdate"));
				
				list.add(temp);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//5. 자원 반납
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		
		
		//6. 결과 리턴
		
		return list;
		
		
		
		
		
	}

	public int insertBoard(Connection con, BoardVo board) {
		//0. 쿼리 작성(쿼리 틀) 
		
		//1. 쿼리 전송 객체 생성(preparedstmt)
		
		//2. 파라미터 설정
		
		//3. 쿼리 실행
		
		//4. 자원 반납
		
		//5. 결과 리턴 
		
		return 0;
	}

}
