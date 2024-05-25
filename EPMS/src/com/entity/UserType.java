package com.entity;

public enum UserType {
	ADMIN("系统管理员",0),EMPLOYEE("员工",1);
	private String name;
	private int index;
	private UserType (String name, int index) {
		this.name = name;
		this.index = index;
	}
	//每一个实体都要有设置自己的属性和获取自己属性的一个方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String toString() {
		return this.name;
	}
	
}
