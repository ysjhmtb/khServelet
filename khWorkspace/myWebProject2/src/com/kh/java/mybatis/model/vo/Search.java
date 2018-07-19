package com.kh.java.mybatis.model.vo;

public class Search {

	private String condition;
	private String keyword;
	private int conditionNum;
	
	
	public Search() {
		
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public int getConditionNum() {
		return conditionNum;
	}


	public void setConditionNum(int conditionNum) {
		this.conditionNum = conditionNum;
	}
	
	
	
}
