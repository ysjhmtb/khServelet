package com.kh.java.member.model.vo;

import java.sql.Date;
import java.util.List;

public class MemberVo {
	private String userId;
	private String password;
	private String userName;
	private char gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobbyStr;
	private List<String> hobby;
	private Date enrolldate;
	
	public MemberVo(){
	}
	
	public MemberVo(String userId, String userName, int age) {
		this.userId = userId;
		this.userName = userName;
		this.age = age;
	}


	public MemberVo(String userId, String password, String userName, char gender, int age, String email, String phone,
			String address, String hobbyStr) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobbyStr = hobbyStr;
	}

	//userId
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserId(){
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	public Date getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}
	public String getHobbyStr() {
		return hobbyStr;
	}
	public void setHobbyStr(String hobbyStr) {
		this.hobbyStr = hobbyStr;
	}
	@Override
	public String toString() {
		return "MemberVo [userId=" + userId + ", password=" + password + ", userName=" + userName + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address + ", hobbyStr="
				+ hobbyStr + ", hobby=" + hobby + ", enrolldate=" + enrolldate + "]";
	}
}
