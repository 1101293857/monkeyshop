package com.lmonkey.dao;

import java.sql.DriverManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;

public class Basedao {
	static {
		try {
			//加载驱动 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getconn() {
		Connection conn = null;
		try {
		    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/lmonkeyshop?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root","laiyuhua120");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	public static int exectuIUD(String sql,Object[] params) {
		int count=0;
		
		Connection conn = Basedao.getconn();
		//准备SQL
		PreparedStatement ps=null;
		
		//insert into user(''''','')value(?,?,?)
		try {
			ps = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++)
			{
				ps.setObject(i+1, params[i]);
			}
			count = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(null,ps,conn);
		}
		return count;
	}
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection conn) {
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{ 
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	 
}
