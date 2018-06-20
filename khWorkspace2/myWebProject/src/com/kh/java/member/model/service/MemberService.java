package com.kh.java.member.model.service;

import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.MemberVo;

public class MemberService {
	
	public MemberVo login(String id, String pwd) {

		return new MemberDao().login(id, pwd);
	}
	
	public MemberVo getMemberId(String id) {
		return new MemberDao().selectMemberId(id);
	}
	
	

	
	public int joinMember(MemberVo m) {
		
		System.out.println("joinMember called");
		
		return new MemberDao().insertMember(m);
	}
	
	public int setMemberInfo(MemberVo m) {
		return new MemberDao().updateMember(m);
	}

	public int deleteMember(String id) {
		
		return new MemberDao().deleteMember(id);
	}
	

	
	

}