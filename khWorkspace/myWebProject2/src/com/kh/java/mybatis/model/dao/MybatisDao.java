package com.kh.java.mybatis.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.java.el.model.vo.Member;

public class MybatisDao {

	public List<Member> selectMemberList(SqlSession session) {
		return session.selectList("MemberMapper.selectMemberList");
	}

}
