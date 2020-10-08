package com.lmonkey.servlet.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.service.LMONKEY_CATEGORYDao;

/**
 * Servlet implementation class Dousercate
 */
@WebServlet("/manage/admin_docateadd")
public class Dousercate extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int fid = Integer.parseInt(request.getParameter("parentid"));
		String name = request.getParameter("classname");
		
		LMONKEY_CATEGORY cate=new LMONKEY_CATEGORY(0,name,fid);
		
		int count = LMONKEY_CATEGORYDao.insert(cate);
		
		response.sendRedirect("admin_cateselect");
	}

}
