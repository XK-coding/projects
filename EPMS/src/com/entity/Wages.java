package com.entity;

public class Wages {
	private Integer code;
	private Integer baseWages;
	private Integer postWages;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getBaseWages() {
		return baseWages;
	}
	public void setBaseWages(Integer baseWages) {
		this.baseWages = baseWages;
	}
	public Integer getPostWages() {
		return postWages;
	}
	public void setPostWages(Integer postWages) {
		this.postWages = postWages;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double d) {
		this.money = d;
	}
	public Integer getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(Integer subsidy) {
		this.subsidy = subsidy;
	}
	public Integer getDeduction() {
		return deduction;
	}
	public void setDeduction(Integer deduction) {
		this.deduction = deduction;
	}
	public double getFact() {
		return fact;
	}
	public void setFact(double d) {
		this.fact = d;
	}
	private double money;
	private Integer subsidy;
	private Integer deduction;
	private double fact;

}
