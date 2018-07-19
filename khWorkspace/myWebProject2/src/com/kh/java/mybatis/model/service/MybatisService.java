package com.kh.java.mybatis.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.mybatis.model.dao.MybatisDao;
import com.kh.java.mybatis.model.vo.Member;
import com.kh.java.mybatis.model.vo.Search;

public class MybatisService {
	
	MybatisDao dao = new MybatisDao();

	public List<Member> selectMemberList(){ 
		
		//오토 커밋을 막기 위해서 false로 설정.
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		List<Member> list = dao.selectMemberList(session);
		session.close();
		
		return list;
		
		
	}

	public Member selectMember(String userid) {
		
		//SqlSession이 기존의 Connection과 유사함.
		SqlSession session 
			= MySqlFactory.getSqlSessionFactory().openSession(false);
		Member member 
			= dao.selectMember(session, userid);
		session.close();
		return member;
		 
	}

	public int updateMember(Member member) {
		SqlSession session 
		= MySqlFactory.getSqlSessionFactory().openSession(false);
		
		int result = dao.updateMember(session, member);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		return result;
	}

	public int deleteMember(String userid) {
		SqlSession session 
		= MySqlFactory.getSqlSessionFactory().openSession(false);
		int result = dao.deleteMember(session, userid);
		
		if(0 < result){
			session.commit();
		}else{
			session.rollback();
		}
		session.close();
		return result;
	}

	public int insertMember(Member member) {
		
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		int result = dao.insertMember(session, member);
		
		if(0 < result) {
			session.commit();
		}else {
			session.rollback();
		}
		
		session.close();
		return result;
		
		
	}

	public List<Member> selectMemberSearch(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
}
