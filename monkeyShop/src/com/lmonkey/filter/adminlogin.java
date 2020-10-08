package com.lmonkey.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class adminlogin
 */
@WebFilter("/manage/*")
public class adminlogin implements Filter {

    /**
     * Default constructor. 
     */
    public adminlogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		req.setCharacterEncoding("UTF-8");
		//resp.setContentType("text/html;charset=utf-8");
		
		
		HttpSession session=req.getSession();
		String flag = (String)session.getAttribute("isadminlogin");

		String request_uri = req.getRequestURI();
		
		String url = request_uri.substring(request_uri.lastIndexOf("/"));
		//String ctxpath = req.getContextPath();

		 
		if(url.contains("admin_") && url.endsWith(".jsp"))
		{
			if(flag != null && flag.equals("1"))
			{
				chain.doFilter(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
		    	out.write("<script>");
				out.write("alert('please enter');");
				out.write("location.href='login.jsp'");
				out.write("</script>");
				out.close();
				return ;
			}		
		}else {
			chain.doFilter(req, resp);
		}
		
		
		return;

		// pass the request along the filter chain
		// chain.doFilter(req, resp); //通过则使用这个
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
