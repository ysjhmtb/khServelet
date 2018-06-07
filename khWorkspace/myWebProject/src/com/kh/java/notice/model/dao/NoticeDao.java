package com.kh.java.notice.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.kh.java.common.JDBCTemplate;
import com.kh.java.notice.model.vo.NoticeVo;

public class NoticeDao {

	public ArrayList<NoticeVo> selectNoticeList(Connection con){
		
		
		//커넥션을 멪는다.
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<NoticeVo> result = new ArrayList<>();
		
		//쿼리 객체 생성.
		try {
			stmt = con.createStatement();
			String query = "SELECT NNO,NTITLE,NCONTENT,NWRITER,NCOUNT,NDATE,USERNAME "
					+ "FROM NOTICE "
					+ "JOIN MEMBER ON (NWRITER = USERID)";
			rs = stmt.executeQuery(query);
			
			
			//결과 처리.(resultset)
			NoticeVo temp = null;
			while(rs.next()) {
				int nno = rs.getInt("nno");
				String title = rs.getString("ntitle");
				String content = rs.getString("ncontent");
				String writer = rs.getString("nwriter");
				int count = rs.getInt("ncount");
				Date date = rs.getDate("ndate");
				String name = rs.getString("username");
				
				temp = new NoticeVo(nno,title,content,writer,count,date);
				temp.setName(name);
				result.add(temp);
				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//close
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		
		return result;
		
		
		
	}
	
	
	
	public NoticeVo selectNotice(Connection con, int noticeNo) {
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		NoticeVo result = null;
		
		
		try {
			//쿼리 전송 객체 생성.
			stmt = con.createStatement();
			//쿼리 작성.
			query = "SELECT NNO,NTITLE,NCONTENT,NWRITER,NCOUNT,NDATE,USERNAME "
					+ "FROM NOTICE " 
					+"JOIN MEMBER ON (NWRITER = USERID) "
					+"WHERE NNO = " + noticeNo;
			
			//쿼리 실행 후 결과 처리.
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				int nno = rs.getInt("nno");
				String title = rs.getString("ntitle");
				String content = rs.getString("ncontent");
				String writer = rs.getString("nwriter");
				int count = rs.getInt("ncount");
				Date date = rs.getDate("ndate");
				String name = rs.getString("username");
				
				result = new NoticeVo(nno,title,content,writer,count,date,name);
				
				
			}
			//close
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
	
		
		return result;
		
	}
	
}









