package com.entity;

public enum UserType {
	ADMIN("ϵͳ����Ա",0),EMPLOYEE("Ա��",1);
	private String name;
	private int index;
	private UserType (String name, int index) {
		this.name = name;
		this.index = index;
	}
	//ÿһ��ʵ�嶼Ҫ�������Լ������Ժͻ�ȡ�Լ����Ե�һ������
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
