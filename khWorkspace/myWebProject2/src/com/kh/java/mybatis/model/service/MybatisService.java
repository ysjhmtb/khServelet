package com.kh.java.mybatis.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.el.model.vo.Member;
import com.kh.java.mybatis.model.dao.MybatisDao;

public class MybatisService {
	
	MybatisDao dao = new MybatisDao();

	public List<Member> selectMemberList(){ 
		
		//오토 커밋을 막기 위해서 false로 설정.
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		List<Member> list = dao.selectMemberList(session);
		session.close();
		
		return list;
		
		
	}
	
}
