package com.test;

import java.util.List;

import com.dao.WagesDAO;
import com.entity.Wages;

public class TestWages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Insert();
//		Update();
//		Delete();
//		Select();
//		SelectAll()

	}
	
	public static void Insert() {
		Wages wages = new Wages();
		wages.setCode(12);
		wages.setBaseWages(1);
		wages.setPostWages(1);
		wages.setMoney(1.0);
		wages.setSubsidy(1);
		wages.setDeduction(1);
		wages.setFact(20.0);
		WagesDAO d = new WagesDAO();
		if (d.add(wages)) {
			System.out.println("保存成功！");
		} else {
			System.out.println("保存失败！");
		}
		
	}
	
	public static void Update() {
		Wages wages = new Wages();
		wages.setBaseWages(11);
		wages.setPostWages(11);
		wages.setMoney(1.10);
		wages.setSubsidy(11);
		wages.setDeduction(11);
		wages.setFact(20.10);
		wages.setCode(12);
		WagesDAO d = new WagesDAO();
		if (d.update(wages)) {
			System.out.println("修改成功！");
		} else {
			System.out.println("修改失败！");
		}
		
	}
	
//	public static void Delete() {
//		WagesDAO d = new WagesDAO();
//		if (d.delete(11)) {
//			System.out.println("删除成功！");
//		} else {
//			System.out.println("修改失败！");
//		}
//	}
	
	public static void Select() {
		WagesDAO w = new WagesDAO();
		Wages wages = w.query(1);
		System.out.println(wages.getBaseWages());
	}
	
//	public static void SelectAll() {
//		WagesDAO w = new WagesDAO();
//		List<Wages> list = w.getAll();
//		for(Wages wages : list) {
//			System.out.println(wages.getCode() +">=" + wages.getBaseWages());
//		}
//		
//	}
	
	

}
