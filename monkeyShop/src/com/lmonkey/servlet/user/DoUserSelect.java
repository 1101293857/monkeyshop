package com.lmonkey.servlet.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.entity.LMONKEY_USER;
import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class DoUserSelect
 */
@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cpage=1; //当前页
		int count=5; //每页数量
		
		//获取用户指定页面
		String cp=request.getParameter("cp");
		
		//接受用户搜索的关键字
		String keyword = request.getParameter("keywords");
		if(cp!=null)
		{
			cpage= Integer.parseInt(cp);
		}else
		{
			cpage=1;
		}
		
		int arr[]=LMONKEY_USERDao.nihaopage(count,keyword);
		
		
		ArrayList<LMONKEY_USER> list=null;
		try {
			list = LMONKEY_USERDao.selectAll(cpage,count,keyword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    //加倒请求对象域里
		request.setAttribute("userlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		
	
		if(keyword !=null)
		{
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		
		request.getRequestDispatcher("admin_user.jsp").forward(request, response);
	
	
	}


}
