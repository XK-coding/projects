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
			
			PreparedStatement ps = conn.prepareCall(sql);	//把sql语句传给数据库操作对象
			ps.setString(1, account.getZhanghao());
			ps.setString(2, account.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {	
				accountRst = new Account();
				accountRst.setId(rs.getInt("id"));
				accountRst.setZhanghao(rs.getString("zhanghao"));
				accountRst.setPassword(rs.getString("password"));
			}
			
			//关闭数据库
			DBConnection.close(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return accountRst;
	}
}
