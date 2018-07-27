package com.kh.firstSpring.notice.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.firstSpring.notice.model.vo.Notice;

@Repository
public class NoticeDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<Notice> selectNoticeList() {
		return sqlSession.selectList("NoticeMapper.selectNoticeList");
	}

	public Notice selectNotice(int no) {
		return sqlSession.selectOne("NoticeMapper.selectNotice", no);
	}
}






