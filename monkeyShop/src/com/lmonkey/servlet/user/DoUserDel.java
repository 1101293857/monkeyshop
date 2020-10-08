package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class DoUserDel
 */
@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String id=request.getParameter("id");
		//加入数据库
		int count=LMONKEY_USERDao.del(id);

		//。。成功或失败重定向到哪里
		if(count>0) {
			response.sendRedirect("admin_douserselect?cp="+request.getParameter("cpage"));
				
		}else {
			PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败')");
			out.write("location.href='manage/admin_douserselect?cp='"+request.getParameter("cpage"));
			out.write("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String ids[]=request.getParameterValues("id[]");
		
		for(int i=0;i<ids.length;i++)
		{
			int count=LMONKEY_USERDao.del(ids[i]);
		}
		//加入数据库


		//。。成功或失败重定向到哪里
		

		response.sendRedirect("admin_douserselect");
				
		
	}

}
