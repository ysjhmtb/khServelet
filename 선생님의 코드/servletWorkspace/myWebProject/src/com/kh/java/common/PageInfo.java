package com.kh.java.common;

public class PageInfo {
	private int currentPage;	//현재 페이지 번호
	private int limit;				//한페이지에 출력 될 페이지 갯수
	private int maxPage;		//마지막 페이지 번호
	private int startPage;		//해당 페이지의 첫페이지 번호
	private int endPage;		//해당 페이지의 마지막페이지 번호
	private int totalCount;		//게시글에 대한 총 갯수
	
	public PageInfo() {
	}
	
	public PageInfo(int currentPage, int limit, int maxPage, int startPage, int endPage, int totalCount) {
		this.currentPage = currentPage;
		this.limit = limit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "PageInfo [currentPage=" + currentPage + ", limit=" + limit + ", maxPage=" + maxPage + ", startPage="
				+ startPage + ", endPage=" + endPage + ", totalCount=" + totalCount + "]";
	}
}
