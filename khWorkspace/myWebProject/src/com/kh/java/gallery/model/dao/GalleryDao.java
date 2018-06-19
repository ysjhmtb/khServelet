package com.kh.java.gallery.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.java.common.JDBCTemplate;
import com.kh.java.gallery.model.vo.AttachmentVo;

public class GalleryDao {
	
	Properties prop = new Properties();
	
	public GalleryDao() {
		String filename = GalleryDao.class.getResource("/gallery/gallery_sql.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			
			while(rs.next()) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		
		
		return list;
	}

}
