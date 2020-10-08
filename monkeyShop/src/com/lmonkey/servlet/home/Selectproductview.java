package com.lmonkey.servlet.home;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lmonkey.entity.LMONKEY_CATEGORY;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_CATEGORYDao;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class Selectproductview
 */
@WebServlet("/selectproductview")
public class Selectproductview extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<LMONKEY_CATEGORY> cate=null;
		ArrayList<LMONKEY_CATEGORY> cate1=null;
		try {
			cate = LMONKEY_CATEGORYDao.selectcate("father");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cate1 = LMONKEY_CATEGORYDao.selectcate("child");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("flist", cate);
		request.setAttribute("clist", cate1);
		
		int id=Integer.parseInt(request.getParameter("id"));
		LMONKEY_PRODUCT p = LMONKEY_PRODUCTDao.selectByid(id);
		request.setAttribute("p", p);
		
		//最近访问
		HttpSession session =request.getSession();
		ArrayList<Integer> ids=(ArrayList<Integer>)session.getAttribute("ids");
		
		if(ids==null)
		{
			ids =new ArrayList<Integer>();
		}
		
		
		
		if(ids!=null && (!ids.contains(id))) {
			ids.add(id);
			
		}
		if(ids.size() > 5)
		{
			ids.remove(0);
		}
		
		session.setAttribute("ids", ids);
		
		if(ids!=null)
		{
			ArrayList<LMONKEY_PRODUCT> ids_product=new ArrayList<LMONKEY_PRODUCT>();
			for(int i=ids.size()-1;i>=0;i--)
			{
				System.out.print(ids.get(0));
				ids_product.add(LMONKEY_PRODUCTDao.selectByid(ids.get(i)));
			}
			request.setAttribute("ids_product", ids_product);
		}
		if(p!=null)
		{
			int cid = p.getPRODUCT_CID();
			ArrayList<LMONKEY_PRODUCT> Clist = LMONKEY_PRODUCTDao.selectByCid(cid);
			request.setAttribute("Clist", Clist);
			
			LMONKEY_CATEGORY cate5=null;
			try {
				cate5 = LMONKEY_CATEGORYDao.selectByid(cid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("cate5", cate5);
		}
		
		request.getRequestDispatcher("productviewlist.jsp").forward(request, response);
	}

	

}
