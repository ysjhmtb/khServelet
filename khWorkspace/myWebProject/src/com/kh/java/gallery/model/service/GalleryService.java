package com.kh.java.gallery.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.java.common.JDBCTemplate;
import com.kh.java.gallery.model.dao.GalleryDao;
import com.kh.java.gallery.model.vo.AttachmentVo;

public class GalleryService {

	public ArrayList<AttachmentVo> selectGalleryList() {
		//커넥션 객체 생성
		Connection con = JDBCTemplate.getConnection();
		
		//비지니스 로직 호출 
		ArrayList<AttachmentVo> list = new GalleryDao().selectGalleryList(con);
		
		//자원 반납
		JDBCTemplate.close(con);
		
		//결과 반환 
		return list;
	}

}
