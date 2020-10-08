package com.lmonkey.servlet.category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.service.LMONKEY_CATEGORYDao;

/**
 * Servlet implementation class Docatedel
 */
@WebServlet("/manage/admin_docatedel")
public class Docatedel extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		int count = LMONKEY_CATEGORYDao.del(id);
		
		if(count>0)
		{
			response.sendRedirect("admin_cateselect");
		}else {
			PrintWriter out =response.getWriter();
			out.write("<script>");
			out.write("alert('修改失败');");
			out.write("location.href='admin_cateselect'");
			out.write("</script>");
		}
	}

	

}
