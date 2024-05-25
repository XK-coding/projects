package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.entity.Wages;
import com.jdbc.DBConnection;

public class WagesDAO {
	//增加功能
	public boolean add(Wages wages) {
		
		//1.连接mysql
		Connection conn = DBConnection.getConn();
		
		//2.预编译sql执行
		String sql = "insert into wages values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, wages.getCode());
			ps.setInt(2, wages.getBaseWages());
			ps.setInt(3, wages.getPostWages());
			ps.setFloat(4, (float) wages.getMoney());
			ps.setInt(5, wages.getSubsidy());
			ps.setInt(6, wages.getDeduction());
			ps.setFloat(7, (float) wages.getFact());
			//执行操作更改
			boolean result = ps.executeUpdate() > 0;
			//关闭数据库
			DBConnection.close(null, ps, conn);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//修改功能
	public boolean update(Wages wages) {
		
		//1.连接mysql
		Connection conn = DBConnection.getConn();
		
		//2.预编译sql执行
		String sql = "update wages set baseWages=?,postWages=?,money=?,subsidy=?,deduction=?,fact=? where code=?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			
			ps.setInt(1, wages.getBaseWages());
			ps.setInt(2, wages.getPostWages());
			ps.setFloat(3, (float) wages.getMoney());
			ps.setInt(4, wages.getSubsidy());
			ps.setInt(5, wages.getDeduction());
			ps.setFloat(6, (float) wages.getFact());
			ps.setInt(7, wages.getCode());
			//执行操作更改
			boolean result = ps.executeUpdate() > 0;
			//关闭数据库
			DBConnection.close(null, ps, conn);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//删除功能
	public boolean delete(String val) {
		
		//1.连接mysql
		Connection conn = DBConnection.getConn();
		
		//2.预编译sql执行
		String sql = "delete from wages where code=?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			
			ps.setString(1,val);
			
			//执行操作更改
			boolean result = ps.executeUpdate() > 0;
			//关闭数据库
			DBConnection.close(null, ps, conn);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//查询指定员工
		public Wages query(int code) {
			
			//1.连接mysql
			Connection conn = DBConnection.getConn();
			
			//2.预编译sql执行
			String sql = "select * from wages where code=?";
			try {
				PreparedStatement ps = conn.prepareCall(sql);
				
				ps.setInt(1,code);
				
				//执行操作更改
				ResultSet rs = ps.executeQuery();
				//创建一份工资对象返回
				Wages w = new Wages();
				while (rs.next()) {
					w.setCode(rs.getInt(1));
					w.setBaseWages(rs.getInt(2));
					w.setPostWages(rs.getInt(3));
					w.setMoney(rs.getDouble(4));
					w.setSubsidy(rs.getInt(5));
					w.setDeduction(rs.getInt(6));
					w.setMoney(rs.getDouble(7));
				}
				
				
				//关闭数据库
				DBConnection.close(rs, ps, conn);
				return w;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	//查询所有员工工资信息 keyword用于搜索模糊查询
	public Vector<Vector<String>> getAll(String keyword) {
		//1.连接mysql
		Connection conn = DBConnection.getConn();
		
		//2.预编译sql执行
		String sql = "select * from wages";
		//如果有关键字，则把它拼接到查询语句当中作限制条件
		if (keyword != null) {
			sql += " where code like '%"+keyword+"%'";
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//执行操作更改
			ResultSet rs = ps.executeQuery();
			//创建一个二维数组返回
			Vector<Vector<String>> list = new Vector<Vector<String>>();
			
			while (rs.next()) {
				Vector<String> w = new Vector<String>();
				w.add(rs.getString(1));
				w.add(rs.getString(2));
				w.add(rs.getString(3));
				w.add(rs.getString(4));
				w.add(rs.getString(5));
				w.add(rs.getString(6));
				w.add(rs.getString(7));
				
				//把当前对象存储到list集合中
				list.add(w);
			}
			//关闭数据库
			DBConnection.close(rs, ps, conn);
			return list;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
