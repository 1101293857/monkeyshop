package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/manage/adminlogin")
public class adminlogin extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		
	    int count =	LMONKEY_USERDao.selectByNM(username,pwd);
	    if(count>0)
	    {
	    	LMONKEY_USER user = LMONKEY_USERDao.selectAdmin(username,pwd);
	    	HttpSession session = request.getSession();
	    	session.setAttribute("name", user);
	    	session.setAttribute("islogin", "1");
	    	if(user.getUSER_STATUS()==2)
	    	{		    	

			    	session.setAttribute("isadminlogin", "1");
			    	response.sendRedirect("/monkeyShop/manage/admin_index.jsp");
	    	}
	    	else
	    	{
	    		response.sendRedirect("/monkeyShop/indexselect");
	    	}
	    	
	    }else {
	    	PrintWriter out=response.getWriter();
	    	out.write("<script>");
			out.write("alert('登入失败');");
			out.write("location.href='login.jsp'");
			out.write("</script>");
			out.close();
	    }
	}
	

}
