package com.lmonkey.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_CART;
import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_CARTDao;

/**
 * Servlet implementation class Showcart
 */
@WebServlet("/showcart")
public class Showcart extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
HttpSession session = request.getSession();
		
		String islogin = (String)session.getAttribute("islogin");
		
		LMONKEY_USER user = (LMONKEY_USER)session.getAttribute("name");
		
		if(user!=null && islogin.equals("1"))
		{
			String uid = (String) user.getUSER_ID();
			
			ArrayList<LMONKEY_CART>  cartlist= LMONKEY_CARTDao.selectByuserid(uid);
			
			request.setAttribute("cartlist", cartlist);
			
			
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}else {
            PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('请先登录后购买');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return ;
		
	}

	
	}
}
