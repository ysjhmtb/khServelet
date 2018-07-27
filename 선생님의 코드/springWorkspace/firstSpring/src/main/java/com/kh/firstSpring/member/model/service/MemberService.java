package com.kh.firstSpring.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.firstSpring.member.model.dao.MemberDao;
import com.kh.firstSpring.member.model.vo.Member;

@Service
public class MemberService {
	@Autowired
	MemberDao dao;
	
	public Member selectMember(Member member) {
		return dao.selectMember(member);
	}

	public int insertMember(Member member) {
		return dao.insertMember(member);
		
	}

	public int updateMember(Member member) {
		return dao.updateMember(member);
	}

}







