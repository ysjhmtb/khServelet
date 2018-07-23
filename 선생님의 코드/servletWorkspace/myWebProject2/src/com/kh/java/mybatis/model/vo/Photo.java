package com.kh.java.mybatis.model.vo;

import java.util.Date;
import java.util.List;

public class Photo {
	private int no;
	private String title;
	private String content;
	private int readCount;
	private Date writeDate;
	private String userId;
	private List<PhotoReply> reply;
	
	public Photo(){}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public List<PhotoReply> getReply() {
		return reply;
	}

	public void setReply(List<PhotoReply> reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "Photo [no=" + no + ", title=" + title + ", content=" + content + ", readCount=" + readCount
				+ ", writeDate=" + writeDate + ", userId=" + userId + ", reply=" + reply + "]";
	}

}



