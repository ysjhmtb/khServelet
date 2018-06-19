package com.kh.java.board.model.vo;

import java.util.Date;

public class CommentVo {
	private int cno;
	private int bno;
	private String content;
	private String writer;
	private String writerNm;
	private Date writeDate;
	private boolean delFlag;
	
	public CommentVo(){}

	public CommentVo(int bno, String content, String writer) {
		this.bno = bno;
		this.content = content;
		this.writer = writer;
	}

	public CommentVo(int cno, int bno, String content, String writer, String writerNm, Date writeDate,
			boolean delFlag) {
		this.cno = cno;
		this.bno = bno;
		this.content = content;
		this.writer = writer;
		this.writerNm = writerNm;
		this.writeDate = writeDate;
		this.delFlag = delFlag;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriterNm() {
		return writerNm;
	}

	public void setWriterNm(String writerNm) {
		this.writerNm = writerNm;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	public String toString() {
		return "CommentVo [cno=" + cno + ", bno=" + bno + ", content=" + content + ", writer=" + writer + ", writerNm="
				+ writerNm + ", writeDate=" + writeDate + ", delFlag=" + delFlag + "]";
	}
}












