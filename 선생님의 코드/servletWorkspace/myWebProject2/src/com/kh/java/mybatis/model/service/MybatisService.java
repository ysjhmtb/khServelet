package com.kh.java.mybatis.model.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.mybatis.model.dao.MybatisDao;
import com.kh.java.mybatis.model.vo.Member;
import com.kh.java.mybatis.model.vo.Photo;
import com.kh.java.mybatis.model.vo.Search;

public class MybatisService {
	MybatisDao dao = new MybatisDao();
	
	public List<Member> selectMemberList(){
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false); 
		List<Member> list = dao.selectMemberList(session);
		session.close();
		return list;
	}

	public Member selectMember(String userid) {
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
		
		if(0 < result){
			session.commit();
		}else{
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
		if(0 < result){
			session.commit();
		}else{
			session.rollback();
		}
		session.close();
		return result;
	}

	public List<Member> selectMemberSearch(Search search) {
		SqlSession session 
		= MySqlFactory.getSqlSessionFactory().openSession(false);
		List<Member> list 
			= dao.selectMemberSearch(session, search);
		session.close();
		return list;
	}

	public List<Photo> selectPhotoList() {
		SqlSession session 
			= MySqlFactory.getSqlSessionFactory().openSession(false);
		List<Photo> list = dao.selectPhotoList(session);
		session.close();
		return list;
	}

	public Photo selectPhoto(HashMap<String, String> params) {
		SqlSession session = MySqlFactory.getSqlSessionFactory().openSession(false);
		Photo photo = dao.selectPhoto(session, params);
		session.close();
		return photo;
	}
	
	
	
	
	
	

}











