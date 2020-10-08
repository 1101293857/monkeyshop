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
 * Servlet implementation class Docateupdate
 */
@WebServlet("/manage/admin_docateupdate")
public class Docateupdate extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		int pid = Integer.parseInt(request.getParameter("parentid"));
		String name = request.getParameter("classname");
		int cid = Integer.parseInt(request.getParameter("id"));
		
		
		int count = LMONKEY_CATEGORYDao.changecate(cid,name,pid);
		
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
