package com.lmonkey.servlet.category;

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
 * Servlet implementation class Tocateadd
 */
@WebServlet("/manage/admin_tocateadd")
public class Tocateadd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<LMONKEY_CATEGORY> catelist=null;
			try {
				 catelist = LMONKEY_CATEGORYDao.selectAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("catelist", catelist);
			request.getRequestDispatcher("admin_cateadd.jsp").forward(request, response);
		
		}

	

}
