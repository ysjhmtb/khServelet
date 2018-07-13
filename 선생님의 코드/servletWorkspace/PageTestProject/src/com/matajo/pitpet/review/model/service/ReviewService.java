package com.matajo.pitpet.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.matajo.pitpet.common.JDBCTemplate;
import com.matajo.pitpet.review.model.dao.ReviewDao;
import com.matajo.pitpet.review.model.vo.ReviewVo;

public class ReviewService {

	public ArrayList<ReviewVo> selectReviewList() {
		// 1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		// 2. dao 메소드 호출
		ArrayList<ReviewVo> list = new ReviewDao().selectReviewList(con);
		// 3. 자원 반납(close)
		JDBCTemplate.close(con);
		// 4. 해당 결과 리턴
		return list;
	}

}
