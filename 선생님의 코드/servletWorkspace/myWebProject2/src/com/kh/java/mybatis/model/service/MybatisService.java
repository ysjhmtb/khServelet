package com.kh.java.mybatis.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.mybatis.model.dao.MybatisDao;
import com.kh.java.mybatis.model.vo.Member;

public class MybatisService {
	MybatisDao dao = new MybatisDao();
	
	public List<Member> selectMemberList(){
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false); 
		List<Member> list = dao.selectMemberList(session);
		session.close();
		return list;
	}
}











