package com.kh.java.mybatis.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.mybatis.model.vo.Member;
import com.kh.java.mybatis.model.vo.Photo;
import com.kh.java.mybatis.model.vo.Search;

public class MybatisDao {
	public List<Member> selectMemberList(SqlSession session) {
		return session.selectList("MemberMapper.selectMemberList");
	}

	public Member selectMember(SqlSession session, String userid) {
		return session.selectOne("MemberMapper.selectMember",userid);
	}

	public int updateMember(SqlSession session, Member member) {
		return session.update("MemberMapper.updateMember", member);
	}

	public int deleteMember(SqlSession session, String userid) {
		return session.delete("MemberMapper.deleteMember", userid);
	}

	public int insertMember(SqlSession session, Member member) {
		return session.insert("MemberMapper.insertMember", member);
	}

	public List<Member> selectMemberSearch(SqlSession session, Search search) {
		return session.selectList("MemberMapper.selectMemberSearch2", search);
	}

	public List<Photo> selectPhotoList(SqlSession session) {
		return session.selectList("PhotoMapper.selectPhotoList");
	}

	public Photo selectPhoto(SqlSession session, HashMap<String, String> params) {
		return session.selectOne("PhotoMapper.selectPhoto", params);
	}
}











