package com.kh.java.notice.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.kh.java.common.JDBCTemplate;
import com.kh.java.gallery.model.dao.GalleryDao;
import com.kh.java.notice.model.vo.NoticeVo;

public class NoticeDaoPstmt {
	Properties prop = new Properties();
	
	public NoticeDaoPstmt(){
		String filename = GalleryDao.class
				.getResource("/notice/notice_sql.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<NoticeVo> selectNoticeList(Connection con) {
		//커넥션을 맺는다
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<NoticeVo> result = new ArrayList<NoticeVo>();
		//쿼리 객체 생성
		try {
			stmt = con.createStatement();
			String query = prop.getProperty("selectNoticeList");
			rs = stmt.executeQuery(query);
			
			//결과 처리(resultset)
			NoticeVo temp = null;
			while(rs.next()){
				int no = rs.getInt("nno");
				String title = rs.getString("ntitle");
				String content = rs.getString("ncontent");
				String writer = rs.getString("nwriter");
				int count = rs.getInt("ncount");
				Date date = rs.getDate("ndate");
				String name = rs.getString("username");
				
				temp = new NoticeVo(no, title, content, writer, count, date);
				temp.setName(name);
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}
	
	public NoticeVo selectNotice(Connection con, int noticeNo){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		NoticeVo result = null;
		try {
			//쿼리 작성
			query = prop.getProperty("selectNotice");
			//쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			//쿼리 실행 후 결과 처리
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int no = rs.getInt("nno");
				String title = rs.getString("ntitle");
				String content = rs.getString("ncontent");
				String writer = rs.getString("nwriter");
				int count = rs.getInt("ncount");
				Date date = rs.getDate("ndate");
				String name = rs.getString("username");
				
				result = new NoticeVo(no, title, content, writer, count, date, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<NoticeVo> selectNoticeKeyword(Connection con, int condition, String keyword) {
		ArrayList<NoticeVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//2. 쿼리 작성
			switch(condition){
			case 1 :
				//제목
				query = prop.getProperty("selectNoticeKeywordTitle");
				break;
			case 2:
				//내용
				query = prop.getProperty("selectNoticeKeywordContent");
				break;
			case 3:
				//작성자
				query = prop.getProperty("selectNoticeKeywordUsername");
				break;
			case 0:
				query = prop.getProperty("selectNoticeKeywordAll");
				break;
			}
			pstmt = con.prepareStatement(query);
			switch(condition){
			case 0:
				pstmt.setString(1, keyword);
				pstmt.setString(2, keyword);
				pstmt.setString(3, keyword);
				break;
			default :
				pstmt.setString(1, keyword);
				break;
			}

			System.out.println("실행 된 쿼리 : " + query);
			//3. 결과 처리
			rs = pstmt.executeQuery();
			list = new ArrayList<NoticeVo>();
			
			NoticeVo temp = null;
			while(rs.next()){
				int no = rs.getInt("nno");
				String title = rs.getString("ntitle");
				String content = rs.getString("ncontent");
				String writer = rs.getString("nwriter");
				int count = rs.getInt("ncount");
				Date date = rs.getDate("ndate");
				String name = rs.getString("username");
				
				temp = new NoticeVo(no, title, content, writer, count, date, name);
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//4. 자원 반납(resultset, statement)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertNotice(Connection con, NoticeVo notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		try {
			query = prop.getProperty("insertNotice");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setString(3, notice.getWriter());
			
			System.out.println("공지 사항 작성 쿼리 : " + query);
			
			//3. 쿼리 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//4. 자원 반납
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateNoticeCount(Connection con, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		try {
			query = prop.getProperty("updateNoticeCount");
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			//3. 쿼리 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//4. 자원 반납(close)
			JDBCTemplate.close(pstmt);
		}
		//5. 결과 반환
		return result;
	}

	public NoticeVo selectLastNotice(Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		NoticeVo result = null;
		try {
			//쿼리 전송 객체 생성
			stmt = con.createStatement();
			//쿼리 작성
			query = prop.getProperty("selectLastNotice");
			//쿼리 실행 후 결과 처리
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				int no = rs.getInt("nno");
				String title = rs.getString("ntitle");
				String content = rs.getString("ncontent");
				String writer = rs.getString("nwriter");
				int count = rs.getInt("ncount");
				Date date = rs.getDate("ndate");
				String name = rs.getString("username");
				
				result = new NoticeVo(no, title, content, writer, count, date, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}
	
	public int updateNotice(Connection con, NoticeVo notice){
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		try {
			query = prop.getProperty("updateNotice");
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setInt(3, notice.getNo());
			
			//3. 쿼리 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//4. 자원 반납(close)
			JDBCTemplate.close(pstmt);
		}
		//5. 결과 반환
		return result;
	}

	public int deleteNotice(Connection con, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		try {
			query = prop.getProperty("deleteNotice");
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//4. 자원 반납(close)
			JDBCTemplate.close(pstmt);
		}
		//5. 결과 반환(return)
		return result;
	}
	
	public NoticeVo selectNoticeLast(Connection con){
		NoticeVo result = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 전송 객체 생성
			stmt = con.createStatement();
			//2. 쿼리문 작성
			query = prop.getProperty("selectNoticeLast");
			//3. 쿼리 실행
			rs = stmt.executeQuery(query);
			//4. 결과 처리(result set -> 객체)
			while(rs.next()){
				String title = rs.getString("ntitle");
				String content = rs.getString("ncontent");
				result = new NoticeVo();
				result.setTitle(title);
				result.setContent(content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		//6. 결과 반환
		return result;
	}
}






























