package com.kh.java.mybatis.model.vo;

import java.util.Date;

public class PhotoReply {
	private int no;
	private int photoNo;
	private String writer;
	private String content;
	private Date writeDate;
	
	public PhotoReply(){}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPhotoNo() {
		return photoNo;
	}

	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "PhotoReply [no=" + no + ", photoNo=" + photoNo + ", writer=" + writer + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}
}
