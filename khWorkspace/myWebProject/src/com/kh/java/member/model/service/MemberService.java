package com.kh.java.member.model.service;

import com.kh.java.member.model.dao.MemberDao;
import com.kh.java.member.model.vo.MemberVo;

public class MemberService {
	
	public MemberVo login(String id, String pwd) {
//		MemberVo result = null;
//		result = new MemberDao().login(id, pwd);
//		return result;
		
		return new MemberDao().login(id, pwd);
	}

}
