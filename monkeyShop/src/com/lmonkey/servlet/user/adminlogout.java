package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminlogout
 */
@WebServlet("/manage/admin_logout")
public class adminlogout extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
        HttpSession session =request.getSession();
        
        
		
		session.removeAttribute("name");
		session.removeAttribute("islogin");
		session.removeAttribute("isadminlogin");
		
		PrintWriter out =response.getWriter();
		
		out.write("<script>");
		out.write("alert('退出成功');");
		out.write("location.href='login.jsp'");
		out.write("</script>");
	}

}
