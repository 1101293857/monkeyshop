package com.lmonkey.service;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_USER;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LMONKEY_USERDao {
	//del
	public static int del(String id) {
		String sql="delete from LMONKEY_USER where USER_ID=? and USER_STATUS=1";
		Object[] params= {id};
		return Basedao.exectuIUD(sql, params);
		
	}
	public static int insert(LMONKEY_USER u) {
		String  sql = "insert into lmonkey_user value(?,?,?,?,?,?,?,?,?)";
		
		Object[] params = {u.getUSER_ID(),u.getUSER_NAME(),u.getUSER_PASSWORD(),
				u.getUSER_SEX(),u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),u.getUSER_MOBILE(),u.getUSER_ADDRESS(),u.getUSER_STATUS()};
		
		return Basedao.exectuIUD(sql, params);
	}
	//update
	public static int update(LMONKEY_USER u) {
		String  sql = "update LMONKEY_USER set USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_IDENITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=?  where USER_ID=?";
		Object[] params = {u.getUSER_NAME(),u.getUSER_PASSWORD(),
				u.getUSER_SEX(),u.getUSER_IDENITY_CODE(),
				u.getUSER_EMAIL(),u.getUSER_MOBILE(),u.getUSER_ADDRESS(),u.getUSER_STATUS(),u.getUSER_ID()};
		
		return Basedao.exectuIUD(sql, params);
	}
	//获取总记录数和总页数
	public static int[] nihaopage(int count,String keyword) {
		int arr[]= {0,1};
		
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		
		try {
			String sql="";
			if(keyword!=null)
			{
				sql="select count(*) from LMONKEY_USER where USER_NAME like?";
				ps=conn.prepareStatement(sql);
				ps.setNString(1, "%"+keyword+"%");
			}
			else
			{
				sql="select count(*) from LMONKEY_USER";
				ps=conn.prepareStatement(sql);
				
			}

			rs=ps.executeQuery();
			while(rs.next())
			{
				arr[0] = rs.getInt(1);
				if(arr[0]%count==0) {
					arr[1]=arr[0]/count;
				}
				else
				{
				arr[1]=arr[0]/count+1;
				
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return arr;
	}
	
	
	//查询表中name的数量
	public static int selectByName(String keyword) {

		int count=0;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		
		try {
			String sql="select count(*) from LMONKEY_USER where USER_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setNString(1, keyword);
			

			rs=ps.executeQuery();
			while(rs.next())
			{
				count = rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return count;
	}
	public static ArrayList<LMONKEY_USER> selectAll(int cpage,int count,String keyword) throws SQLException
	{
		ArrayList<LMONKEY_USER> list = new ArrayList<LMONKEY_USER>();
		//声明结果集获取对象
		ResultSet rs=null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps=null;
		try {
			
			String sql="";
			if(keyword!=null)
			{
				sql="select * from lmonkey_user where USER_NAME like ? order by USER_ID desc limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%" +keyword +"%");
				ps.setInt(2, (cpage-1)*count);
				ps.setInt(3, count);
			}
			else
			{				
			
				sql="select * from lmonkey_user order by USER_ID desc limit ?,?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, (cpage-1)*count);
				ps.setInt(2, count);
			}
			
			rs=ps.executeQuery();
			while(rs.next()) {
				LMONKEY_USER u=new LMONKEY_USER(rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS"));
				list.add(u);
		}
	}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
//通过id查找
	public static LMONKEY_USER selectByid(String id) throws SQLException
	{
		LMONKEY_USER u=null;
		//声明结果集获取对象
		ResultSet rs=null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps=null;
		try {
			String sql="select * from lmonkey_user where USER_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setNString(1, id);
			
			
			rs=ps.executeQuery();
			while(rs.next()) {
				 u=new LMONKEY_USER(rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS"));
		}
	}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}

	//查找数据库中是否有该条数据
	public static int selectByNM(String userName,String password)
	{
		int count=0;
		LMONKEY_USER u=null;
		//声明结果集获取对象
		ResultSet rs=null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps=null;
		try {
			String sql="select count(*) from LMONKEY_USER where USER_ID=? and USER_PASSWORD=?";
			ps=conn.prepareStatement(sql);
			ps.setNString(1, userName);
			ps.setNString(2, password);
			
			
			rs=ps.executeQuery();
			while(rs.next()) {
				count=rs.getInt(1);
		}
	}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return count;
	}
	
	//通过用户名和密码查询信息
	public static LMONKEY_USER selectAdmin(String username,String pwd)
	{
		LMONKEY_USER u=null;
		//声明结果集获取对象
		ResultSet rs=null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps=null;
		try {
			String sql="select * from lmonkey_user where USER_ID=? and USER_PASSWORD=?";
			ps=conn.prepareStatement(sql);
			ps.setNString(1, username);
			ps.setNString(2, pwd);
			
			
			rs=ps.executeQuery();
			while(rs.next()) {
				 u=new LMONKEY_USER(rs.getString("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("USER_PASSWORD"),
						rs.getString("USER_SEX"),
						rs.getString("USER_IDENITY_CODE"),
						rs.getString("USER_EMAIL"),
						rs.getString("USER_MOBILE"),
						rs.getString("USER_ADDRESS"),
						rs.getInt("USER_STATUS"));
		}
	}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}

}
