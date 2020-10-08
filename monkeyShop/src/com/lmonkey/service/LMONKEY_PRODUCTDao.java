package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.entity.LMONKEY_USER;

public class LMONKEY_PRODUCTDao {
	public static int insert(LMONKEY_PRODUCT u) {
		String  sql = "insert into lmonkey_product value(null,?,?,?,?,?,?,?)";
		
		Object[] params = {u.getPRODUCT_NAME(),u.getPRODUCT_DESCRIPTION(),u.getPRODUCT_PRICE(),
				u.getPRODUCT_NUM(),u.getPRODUCT_FID(),u.getPRODUCT_CID(),u.getPRODUCT_FILENAME()};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	public static ArrayList<LMONKEY_PRODUCT> selectAll() throws SQLException
	{
		ArrayList<LMONKEY_PRODUCT> list = new ArrayList<LMONKEY_PRODUCT>();
		//声明结果集获取对象
		ResultSet rs=null;
		//获取连接对象
		Connection conn = Basedao.getconn();
		
		PreparedStatement ps=null;
		try {
			
			String sql="";
			
			sql="select * from lmonkey_product";
			ps=conn.prepareStatement(sql);
		
			rs=ps.executeQuery();
			while(rs.next()) {
				LMONKEY_PRODUCT u=new LMONKEY_PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getInt("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_NUM"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME"));
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
	
	
	public static ArrayList<LMONKEY_PRODUCT> selectByFid(int id) {


		ArrayList<LMONKEY_PRODUCT> list =new ArrayList<LMONKEY_PRODUCT>();;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		
		try {
			String sql="select * from LMONKEY_PRODUCT where PRODUCT_FID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			

			rs=ps.executeQuery();
			while(rs.next())
			{
				LMONKEY_PRODUCT u=new LMONKEY_PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getInt("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_NUM"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME"));
				list.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		System.out.print(list.size());
		return list;
	}
	
	public static ArrayList<LMONKEY_PRODUCT> selectByCid(int id) {


		ArrayList<LMONKEY_PRODUCT> list =new ArrayList<LMONKEY_PRODUCT>();;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		
		try {
			String sql="select * from LMONKEY_PRODUCT where PRODUCT_CID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			

			rs=ps.executeQuery();
			while(rs.next())
			{
				LMONKEY_PRODUCT u=new LMONKEY_PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getInt("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_NUM"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME"));
				list.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	public static LMONKEY_PRODUCT selectByid(int id) {


		LMONKEY_PRODUCT u=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		
		try {
			String sql="select * from LMONKEY_PRODUCT where PRODUCT_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			

			rs=ps.executeQuery();
			while(rs.next())
			{
                      u=new LMONKEY_PRODUCT(
						rs.getInt("PRODUCT_ID"),
						rs.getString("PRODUCT_NAME"),
						rs.getString("PRODUCT_DESCRIPTION"),
						rs.getInt("PRODUCT_PRICE"),
						rs.getInt("PRODUCT_NUM"),
						rs.getInt("PRODUCT_FID"),
						rs.getInt("PRODUCT_CID"),
						rs.getString("PRODUCT_FILENAME"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
}
