package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lmonkey.entity.*;
import com.lmonkey.service.LMONKEY_USERDao;
/**
 * Servlet implementation class DouserAdd
 */
@WebServlet("/manage/admin_douseradd")
public class DouserAdd extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		//创建实体
		//LMONKEY_USER u =new LMONKEY_USER(username,name,pwd,sex,year,null,email,mobile,address,1);
		LMONKEY_USER u =new LMONKEY_USER(username,name,pwd,sex,null,email,mobile,address,1);
		//加入数据库
		int count=LMONKEY_USERDao.insert(u);

		//。。成功或失败重定向到哪里
		if(count>0) {
			response.sendRedirect("admin_douserselect");
				
		}else {
			PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败')");
			out.write("location.href='manage/admin_useradd.jsp");
			out.write("</script>");
		}
	}

}
