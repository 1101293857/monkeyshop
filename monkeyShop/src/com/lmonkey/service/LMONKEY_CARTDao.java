package com.lmonkey.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lmonkey.dao.Basedao;
import com.lmonkey.entity.LMONKEY_CART;
import com.lmonkey.entity.LMONKEY_PRODUCT;

public class LMONKEY_CARTDao {
	public static int insert(LMONKEY_CART u) {
		String  sql = "insert into lmonkey_cart value(null,?,?,?,?,?,?,?,?)";
		
		Object[] params = {u.getCART_P_FILENAME(),u.getCART_P_NAME(),u.getCART_P_PRICE(),
				u.getCART_QUANTITY(),u.getCART_P_STOCK(),u.getCART_P_ID(),u.getCART_U_ID(),
				u.getCART_VALID()};
		
		return Basedao.exectuIUD(sql, params);
	}
	
	public static ArrayList<LMONKEY_CART> selectByuserid(String id) {


		ArrayList<LMONKEY_CART> list =new ArrayList<LMONKEY_CART>();;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		
		try {
			String sql="select * from LMONKEY_CART where CART_U_ID=? and CART_VALID=1 order by CART_ID desc";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			

			rs=ps.executeQuery();
			while(rs.next())
			{
				LMONKEY_CART u=new LMONKEY_CART(rs.getInt("CART_ID"),
						rs.getString("CART_P_FILENAME"),
						rs.getString("CART_P_NAME"),
						rs.getDouble("CART_P_PRICE"),
						rs.getInt("CART_QUANTITY"),
						rs.getInt("CART_P_STOCK"),
						rs.getInt("CART_P_ID"),
						rs.getString("CART_U_ID"),
						rs.getInt("CART_VALID"));
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
	public static LMONKEY_CART getcartshop(String uid,String product_id) {


		LMONKEY_CART list =null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		
		try {
			String sql="select * from LMONKEY_CART where CART_U_ID=? and CART_P_ID=? and CART_VALID=1 order by CART_ID desc";
			ps=conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setInt(2, Integer.parseInt(product_id));

			rs=ps.executeQuery();
			while(rs.next())
			{
				list=new LMONKEY_CART(rs.getInt("CART_ID"),
						rs.getString("CART_P_FILENAME"),
						rs.getString("CART_P_NAME"),
						rs.getDouble("CART_P_PRICE"),
						rs.getInt("CART_QUANTITY"),
						rs.getInt("CART_P_STOCK"),
						rs.getInt("CART_P_ID"),
						rs.getString("CART_U_ID"),
						rs.getInt("CART_VALID"));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	
	public static LMONKEY_CART getcart(String id) {


		LMONKEY_CART list =null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		
		try {
			String sql="select * from LMONKEY_CART where CART_ID=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));

			rs=ps.executeQuery();
			while(rs.next())
			{
				list=new LMONKEY_CART(rs.getInt("CART_ID"),
						rs.getString("CART_P_FILENAME"),
						rs.getString("CART_P_NAME"),
						rs.getDouble("CART_P_PRICE"),
						rs.getInt("CART_QUANTITY"),
						rs.getInt("CART_P_STOCK"),
						rs.getInt("CART_P_ID"),
						rs.getString("CART_U_ID"),
						rs.getInt("CART_VALID"));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	public static int updatenum(int cartid,int count)
	{
		String sql = "update lmonkey_cart set CART_QUANTITY=? where CART_ID=?";
		Object[] params = {count,cartid};
		
		return Basedao.exectuIUD(sql, params);
	}
}
