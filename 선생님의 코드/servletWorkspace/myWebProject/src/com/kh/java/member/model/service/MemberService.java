package com.kh.java.member.model.service;

import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.MemberVo;

public class MemberService {
	
	public MemberVo login(String id, String pwd){
//		MemberVo result = null;
//		result = new MemberDao().login(id, pwd);
//		return result;
		//selectMemberList
		return new MemberDao().login(id, pwd);
	}
	public MemberVo getMemberId(String id){
		return new MemberDao().selectMemberId(id);
	}
	
	
	public int joinMember(MemberVo m){
		return new MemberDao().insertMember(m);
	}
	
	public int setMemberInfo(MemberVo m){
		return new MemberDao().updateMember(m);
	}
	public int deleteMember(String id) {
		return new MemberDao().deleteMember(id);
	}
	
	//트랜젝션 
	//커넥션 관리, 트렌젝션 처리(commit, rollback)
	//게시글
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}







