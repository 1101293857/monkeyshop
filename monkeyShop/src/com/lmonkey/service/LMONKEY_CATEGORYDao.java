package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_USER;

public class LMONKEY_CATEGORYDao {

	/**
	 * 获取所有分类
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<LMONKEY_CATEGORY> selectAll() throws SQLException
	{
		ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
		//声明结果集获取对象
		ResultSet rs=null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps=null;
		try {
			
			String sql="";
			
			sql="select * from lmonkey_category";
			ps=conn.prepareStatement(sql);
		
			rs=ps.executeQuery();
			while(rs.next()) {
				LMONKEY_CATEGORY u=new LMONKEY_CATEGORY(rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID"));
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
	/**
	 * 查询分类  子分类和父级分类
	 * @return flag="father" 获取父分类 flag="child" 获取子分类
	 * @throws SQLException
	 */
	public static ArrayList<LMONKEY_CATEGORY> selectcate(String flag) throws SQLException
	{
		ArrayList<LMONKEY_CATEGORY> list = new ArrayList<LMONKEY_CATEGORY>();
		//声明结果集获取对象
		ResultSet rs=null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps=null;
		try {
			String sql=null;
			if(flag!=null && flag.equals("father"))
			{
				sql="select * from lmonkey_category where CATE_PARENT_ID=0";
			}else
			{
				sql="select * from lmonkey_category where CATE_PARENT_ID!=0";
			}
			ps=conn.prepareStatement(sql);
		
			rs=ps.executeQuery();
			while(rs.next()) {
				LMONKEY_CATEGORY u=new LMONKEY_CATEGORY(rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID"));
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
	//插入
	public static int insert(LMONKEY_CATEGORY u) {
		String  sql = "insert into lmonkey_category value(null,?,?)";
		
		Object[] params = {u.getCATE_NAME(),u.getCATE_PARENT_ID()};
		
		
		return Basedao.exectuIUD(sql, params);
	}
	//通过id查找
	public static LMONKEY_CATEGORY selectByid(int id) throws SQLException
	{
		LMONKEY_CATEGORY u=null;
		//声明结果集获取对象
		ResultSet rs=null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps=null;
		try {
			String sql="select * from lmonkey_category where CATE_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			rs=ps.executeQuery();
			while(rs.next()) {
				 u=new LMONKEY_CATEGORY(rs.getInt("CATE_ID"),
						rs.getString("CATE_NAME"),
						rs.getInt("CATE_PARENT_ID")
						);
		}
	}catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}
	//修改
	public static int changecate(int id,String name,int pid) {
		String  sql = "update LMONKEY_CATEGORY set CATE_NAME=?,CATE_PARENT_ID=?  where CATE_ID=?";
		Object[] params = {name,pid,id};
		
		return Basedao.exectuIUD(sql, params);
	}
	//删除
	public static int del(int id) {
		String sql="delete from LMONKEY_CATEGORY where CATE_ID=?";
		Object[] params= {id};
		return Basedao.exectuIUD(sql, params);
		
	}
}
