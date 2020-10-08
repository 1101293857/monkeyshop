package com.lmonkey.servlet.home;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_CATEGORYDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class selectproductlist
 */
@WebServlet("/selectproductlist")
public class selectproductlist extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		
		int id=0;
		ArrayList<LMONKEY_PRODUCT> list = null;
		if(fid !=null)
		{
			id = Integer.parseInt(fid);
			list = LMONKEY_PRODUCTDao.selectByFid(id);
		}
		if(cid !=null)
		{
			id = Integer.parseInt(cid);
			list = LMONKEY_PRODUCTDao.selectByCid(id);
		}
		LMONKEY_CATEGORY cate2=null;
		try {
			cate2=LMONKEY_CATEGORYDao.selectByid(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("namep", cate2.getCATE_NAME());
		request.setAttribute("list", list);
		request.getRequestDispatcher("productlist.jsp").forward(request, response);
	}

	
}
