package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	//1.����jdbc����mysql������
	public final static String driver = "com.mysql.cj.jdbc.Driver";
	
	//2.����mysql���ݿ�ĵ�ַ
	public final static String url = "jdbc:mysql://localhost:3306/wages";
	
	//3.����mysql���û���
	public final static String user = "root";
	
	//4.����mysql������
	public final static String pwd = "txk0x7d2";
	
	//static��̬��������jdbc������
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����mysql�����Ӷ���
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//�ر����ӣ���֤mysql��Դ���ͷţ��ܹ����ʹ����Դ
	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��֤jdbc��ʹ��
	public static void main(String[] args) {
		System.out.println(getConn()+"���ݿ����ӳɹ���");
	}

}
