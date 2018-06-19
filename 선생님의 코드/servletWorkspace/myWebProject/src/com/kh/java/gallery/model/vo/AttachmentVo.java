package com.kh.java.gallery.model.vo;

import java.util.Date;

public class AttachmentVo {
	private int fno;
	private int bno;
	private String originName;
	private String changeName;
	private String path;
	private Date uploadDate;
	private int fileLevel;
	private int downloadCount;
	private String delflag;
	//====================DB table
	private String username;
	private String title;
	private String content;
	private Date writeDate;
	//====================화면 출력용 변수
	
	public AttachmentVo(){}

	public AttachmentVo(int fno, int bno, String originName, String changeName, String path, Date uploadDate,
			int fileLevel, int downloadCount, String delflag) {
		this.fno = fno;
		this.bno = bno;
		this.originName = originName;
		this.changeName = changeName;
		this.path = path;
		this.uploadDate = uploadDate;
		this.fileLevel = fileLevel;
		this.downloadCount = downloadCount;
		this.delflag = delflag;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getFileLevel() {
		return fileLevel;
	}

	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "AttachmentVo [fno=" + fno + ", bno=" + bno + ", originName=" + originName + ", changeName=" + changeName
				+ ", path=" + path + ", uploadDate=" + uploadDate + ", fileLevel=" + fileLevel + ", downloadCount="
				+ downloadCount + ", delflag=" + delflag + "]";
	}
}
