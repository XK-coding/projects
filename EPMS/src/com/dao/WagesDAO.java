package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.entity.Wages;
import com.jdbc.DBConnection;

public class WagesDAO {
	//���ӹ���
	public boolean add(Wages wages) {
		
		//1.����mysql
		Connection conn = DBConnection.getConn();
		
		//2.Ԥ����sqlִ��
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
			//ִ�в�������
			boolean result = ps.executeUpdate() > 0;
			//�ر����ݿ�
			DBConnection.close(null, ps, conn);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//�޸Ĺ���
	public boolean update(Wages wages) {
		
		//1.����mysql
		Connection conn = DBConnection.getConn();
		
		//2.Ԥ����sqlִ��
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
			//ִ�в�������
			boolean result = ps.executeUpdate() > 0;
			//�ر����ݿ�
			DBConnection.close(null, ps, conn);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//ɾ������
	public boolean delete(String val) {
		
		//1.����mysql
		Connection conn = DBConnection.getConn();
		
		//2.Ԥ����sqlִ��
		String sql = "delete from wages where code=?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			
			ps.setString(1,val);
			
			//ִ�в�������
			boolean result = ps.executeUpdate() > 0;
			//�ر����ݿ�
			DBConnection.close(null, ps, conn);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//��ѯָ��Ա��
		public Wages query(int code) {
			
			//1.����mysql
			Connection conn = DBConnection.getConn();
			
			//2.Ԥ����sqlִ��
			String sql = "select * from wages where code=?";
			try {
				PreparedStatement ps = conn.prepareCall(sql);
				
				ps.setInt(1,code);
				
				//ִ�в�������
				ResultSet rs = ps.executeQuery();
				//����һ�ݹ��ʶ��󷵻�
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
				
				
				//�ر����ݿ�
				DBConnection.close(rs, ps, conn);
				return w;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	//��ѯ����Ա��������Ϣ keyword��������ģ����ѯ
	public Vector<Vector<String>> getAll(String keyword) {
		//1.����mysql
		Connection conn = DBConnection.getConn();
		
		//2.Ԥ����sqlִ��
		String sql = "select * from wages";
		//����йؼ��֣������ƴ�ӵ���ѯ��䵱������������
		if (keyword != null) {
			sql += " where code like '%"+keyword+"%'";
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//ִ�в�������
			ResultSet rs = ps.executeQuery();
			//����һ����ά���鷵��
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
				
				//�ѵ�ǰ����洢��list������
				list.add(w);
			}
			//�ر����ݿ�
			DBConnection.close(rs, ps, conn);
			return list;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
