package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Account;
import com.jdbc.DBConnection;

public class AccountDAO {
	public Account login(Account account) {
		Account accountRst = null;
		Connection conn = DBConnection.getConn();
		String sql = "select * from account where zhanghao=? and password=?";
		try {
			
			PreparedStatement ps = conn.prepareCall(sql);	//��sql��䴫�����ݿ��������
			ps.setString(1, account.getZhanghao());
			ps.setString(2, account.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {	
				accountRst = new Account();
				accountRst.setId(rs.getInt("id"));
				accountRst.setZhanghao(rs.getString("zhanghao"));
				accountRst.setPassword(rs.getString("password"));
			}
			
			//�ر����ݿ�
			DBConnection.close(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return accountRst;
	}
}
