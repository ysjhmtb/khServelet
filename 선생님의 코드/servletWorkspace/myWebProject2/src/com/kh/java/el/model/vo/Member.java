package com.kh.java.el.model.vo;

public class Member {
	private String name;
	private int age;
	private String phone;
	
	public Member(){
	}
	public Member(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
}
