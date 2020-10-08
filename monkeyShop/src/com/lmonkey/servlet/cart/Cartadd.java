package com.lmonkey.servlet.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_CART;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_CARTDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class Cartadd
 */
@WebServlet("/cartadd")
public class Cartadd extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LMONKEY_PRODUCT p=null;
		String product_id = request.getParameter("id");
		String count = request.getParameter("count");
		String url = request.getParameter("url");
		
		HttpSession session = request.getSession();
		
		String islogin = (String)session.getAttribute("islogin");
		
		LMONKEY_USER user = (LMONKEY_USER)session.getAttribute("name");
		
		if(user!=null && islogin.equals("1"))
		{
			String uid = (String) user.getUSER_ID();
			
			//通过商品id和用户id
			
			LMONKEY_CART forcart = LMONKEY_CARTDao.getcartshop(uid,product_id);
			
			if(forcart !=null)
			{
				int forcartnum = forcart.getCART_QUANTITY();
				
				
				int newcount = forcartnum +Integer.parseInt(count);
				if(newcount>5)
					newcount=5;
				int jj=LMONKEY_CARTDao.updatenum(forcart.getCART_ID(),newcount);
			}
			else {
				if(product_id!=null) {
					p=LMONKEY_PRODUCTDao.selectByid(Integer.parseInt(product_id));
				}
				
				LMONKEY_CART cart = new LMONKEY_CART(0,
						p.getPRODUCT_FILENAME(),
						p.getPRODUCT_NAME(),
						(double)p.getPRODUCT_PRICE(),
						Integer.parseInt(count),
						p.getPRODUCT_NUM(),
						p.getPRODUCT_ID(),
						uid,
						1				
						);
				int Count=LMONKEY_CARTDao.insert(cart);
			}
		}else {
            PrintWriter out =response.getWriter();
			
			out.write("<script>");
			out.write("alert('请先登录后购买');");
			out.write("location.href='login.jsp';");
			out.write("</script>");
			out.close();
			return ;
		}
		
		if(url.equals("z")) {
			response.sendRedirect("showcart");
			
		}
		else {
			response.sendRedirect("selectproductview?id="+product_id);
		}
	}

	
}
