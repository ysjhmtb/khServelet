package com.kh.firstSpring.notice.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.firstSpring.notice.model.dao.NoticeDao;
import com.kh.firstSpring.notice.model.vo.Notice;

@Service
public class NoticeService {
	@Autowired
	NoticeDao dao;

	public List<Notice> selectNoticeList() {
		return dao.selectNoticeList();
	}

	public Notice selectNotice(int no) {
		return dao.selectNotice(no);
	}
	
	
}
