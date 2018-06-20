package com.kh.java.gallery.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.java.board.model.vo.BoardVo;
import com.kh.java.common.JDBCTemplate;
import com.kh.java.gallery.model.vo.AttachmentVo;
import com.sun.xml.internal.ws.api.message.Attachment;

public class GalleryDao {
	Properties prop = new Properties();
	
	public GalleryDao(){
		String filename = GalleryDao.class
						.getResource("/gallery/gallery_sql.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<AttachmentVo> selectGalleryList(Connection con) {
		ArrayList<AttachmentVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = prop.getProperty("selectGalleryList");
			
			rs = stmt.executeQuery(query);
			
			list = new ArrayList<AttachmentVo>();
			AttachmentVo temp = null;
			while(rs.next()){
				temp = new AttachmentVo();
				temp.setFno(rs.getInt("fno"));
				temp.setBno(rs.getInt("bno"));
				temp.setOriginName(rs.getString("origin_name"));
				temp.setChangeName(rs.getString("change_name"));
				temp.setPath(rs.getString("file_path"));
				temp.setUploadDate(rs.getDate("upload_date"));
				temp.setFileLevel(rs.getInt("file_level"));
				temp.setDownloadCount(rs.getInt("download_count"));
				temp.setTitle(rs.getString("btitle"));
				temp.setContent(rs.getString("bcontent"));
				temp.setWriteDate(rs.getDate("bdate"));
				temp.setUsername(rs.getString("username"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return list;
	}
	
	public int getBoardBno(Connection con, BoardVo b) {
		//현재 인원이 작성한 게시글 중 최대값
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		query = prop.getProperty("selectWriteBno");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getWriter());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				result = rs.getInt("bno");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertAttachVo(Connection con, ArrayList<AttachmentVo> list) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachVo");
		try {
			for(int i = 0 ; i < list.size() ; i++){
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, list.get(i).getBno());
				pstmt.setString(2, list.get(i).getOriginName());
				pstmt.setString(3, list.get(i).getChangeName());
				pstmt.setString(4, list.get(i).getPath());
				pstmt.setInt(5, (i == 0 ? 0 : 1));
				
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<AttachmentVo> selectGallery(Connection con, int bno) {
		ArrayList<AttachmentVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = prop.getProperty("selectGallery");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			list = new ArrayList<AttachmentVo>();
			AttachmentVo temp = null;
			while(rs.next()){
				temp = new AttachmentVo();
				temp.setChangeName(rs.getString("change_name"));
				temp.setFno(rs.getInt("fno"));
				temp.setBno(rs.getInt("bno"));
				temp.setUsername(rs.getString("username"));
				temp.setDownloadCount(rs.getInt("download_count"));
				temp.setWriteDate(rs.getDate("bdate"));
				temp.setTitle(rs.getString("btitle"));
				temp.setContent(rs.getString("bcontent"));
				temp.setPath(rs.getString("file_path"));
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
}






