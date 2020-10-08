package com.lmonkey.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class usernamecheck
 */
@WebServlet("/usernamecheck")
public class usernamecheck extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		
		int count =LMONKEY_USERDao.selectByName(name);
		
		PrintWriter out =response.getWriter();
		
		if(count>0) {
			out.print("false");
		}else {
			out.print("true");
		}
		out.close();
	}


}
