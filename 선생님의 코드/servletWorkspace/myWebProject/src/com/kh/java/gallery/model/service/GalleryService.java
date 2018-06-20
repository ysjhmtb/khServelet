package com.kh.java.gallery.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.java.board.model.dao.BoardDao;
import com.kh.java.board.model.vo.BoardVo;
import com.kh.java.common.JDBCTemplate;
import com.kh.java.gallery.model.dao.GalleryDao;
import com.kh.java.gallery.model.vo.AttachmentVo;

public class GalleryService {

	public ArrayList<AttachmentVo> selectGalleryList() {
		//커넥션 객체 생성
		Connection con = JDBCTemplate.getConnection();
		//비지니스 로직 호출
		ArrayList<AttachmentVo> list 
						= new GalleryDao().selectGalleryList(con);
		//자원 반납
		JDBCTemplate.close(con);
		//결과 반환
		return list;
	}

	public int insertAttach(BoardVo b, ArrayList<AttachmentVo> list) {
		//1. 보드 객체를 db에 저장
		//3. attachment 객체들에 외래키 설정
		Connection con = JDBCTemplate.getConnection();
		int result = -1;
		result = new BoardDao().insertBoard(con, b);
		
		if(0 < result){
			//2. 추가 된 보드 객체의 키 값을 조회
			int bno = new GalleryDao().getBoardBno(con, b);
			System.out.println(bno);
			//3. attachment 객체들에 외래키 설정
			for(AttachmentVo av : list){
				av.setBno(bno);
			}
		}
		
		//4. 해당 객체들 db에 저장
		int result2 = new GalleryDao().insertAttachVo(con, list);
		if(0 < result2 && 0 < result){
			JDBCTemplate.commit(con);
			result = 1;
		}else{
			JDBCTemplate.rollback(con);
		}
		JDBCTemplate.close(con);
		
		return result;
	}

	public ArrayList<AttachmentVo> selectGallery(int bno) {
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<AttachmentVo> list = new GalleryDao().selectGallery(con, bno);
		
		JDBCTemplate.close(con);
		
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
