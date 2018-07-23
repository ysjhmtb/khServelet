package com.kh.java.notice.model.vo;

import java.util.Date;

public class NoticeVo {
	private int nno;
	private String ntitle;
	private String ncontent;
	private String nwriter;
	private int ncount;
	private Date ndate;
	private String name;
	
	public NoticeVo(){
	}
	
	
	

	public NoticeVo(int nno, String ntitle, String ncontent, String nwriter, int ncount, Date ndate, String name) {
		super();
		this.nno = nno;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.nwriter = nwriter;
		this.ncount = ncount;
		this.ndate = ndate;
		this.name = name;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNwriter() {
		return nwriter;
	}

	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}

	public int getNcount() {
		return ncount;
	}

	public void setNcount(int ncount) {
		this.ncount = ncount;
	}

	public Date getNdate() {
		return ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

	@Override
	public String toString() {
		return "NoticeVo [nno=" + nno + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", nwriter=" + nwriter
				+ ", ncount=" + ncount + ", ndate=" + ndate + ", name=" + name + "]";
	}
}









