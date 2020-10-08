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
import com.lmonkey.service.LMONKEY_CATEGORYDao;

/**
 * Servlet implementation class indexSelect
 */
@WebServlet("/indexselect")
public class indexSelect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<LMONKEY_CATEGORY> cate=null;
		ArrayList<LMONKEY_CATEGORY> cate1=null;
		try {
			cate = LMONKEY_CATEGORYDao.selectcate("father");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cate1 = LMONKEY_CATEGORYDao.selectcate("child");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("flist", cate);
		request.setAttribute("clist", cate1);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}



}
