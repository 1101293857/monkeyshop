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
 * Servlet implementation class Orderselect
 */
@WebServlet("/orderselect")
public class Orderselect extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
		
		String islogin = (String)session.getAttribute("islogin");
		
		LMONKEY_USER user = (LMONKEY_USER)session.getAttribute("name");
		
		String eids = request.getParameter("eids");
		System.out.print("jjj");
		System.out.print(eids);
		if(user!=null && islogin.equals("1"))
		{
			String ids[]=eids.split(",");
			
			ArrayList<LMONKEY_CART>  list= new ArrayList<LMONKEY_CART>();
			
			for(int i=0;i<ids.length;i++)
			{
				LMONKEY_CART es=LMONKEY_CARTDao.getcart(ids[i]);
				list.add(es);
			}
			request.setAttribute("shoplist", list);
			request.getRequestDispatcher("order.jsp").forward(request, response);
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

	


