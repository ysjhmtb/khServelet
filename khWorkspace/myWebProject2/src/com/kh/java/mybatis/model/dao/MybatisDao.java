package com.kh.java.mybatis.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.mybatis.model.vo.Member;


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

	

}
