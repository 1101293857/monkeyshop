package com.lmonkey.servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.lmonkey.entity.LMONKEY_PRODUCT;
import com.lmonkey.service.LMONKEY_PRODUCTDao;

/**
 * Servlet implementation class Doproductadd
 */
@WebServlet("/manage/admin_doproductadd")
public class Doproductadd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建smartupload对象
		SmartUpload su=new SmartUpload();
		
		//初始化
		su.initialize(this.getServletConfig(), request,response);
		
		//上传过程
		try {
			su.upload();
		} catch (ServletException | IOException | SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取上传的文件对象
		Files fs=su.getFiles();
		
		File f=fs.getFile(0);
		
		String filename = f.getFileName();
		
		
		try {
			su.save("images/product");
		} catch (ServletException | IOException | SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
         Request req= su.getRequest();
         
         String productname = req.getParameter("productname");
         String id = req.getParameter("parentid");
         String productprice = req.getParameter("productprice");
         String productdesc = req.getParameter("productdesc");
         String productnum = req.getParameter("productnum");
         
         LMONKEY_PRODUCT product = new LMONKEY_PRODUCT(
        		 				0,
        		 				productname,
        		 				productdesc,
        		 				Integer.parseInt(productprice),
        		 				Integer.parseInt(productnum),
        		 				Integer.parseInt(id.split("-")[1]),
        		 				Integer.parseInt(id.split("-")[0]),
        		 				filename
        		 );

         int count = LMONKEY_PRODUCTDao.insert(product);
         
         if(count>0)
 		{
 			response.sendRedirect("admin_productselect");
 		}else {
 			PrintWriter out =response.getWriter();
 			out.write("<script>");
 			out.write("alert('产品添加失败');");
 			out.write("location.href='manage/admin_toproductadd'");
 			out.write("</script>");
 		}
         
	}

}
