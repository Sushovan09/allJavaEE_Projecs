package com.sushovan;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.*;

//@WebServlet("/demo2")
public class SecondServlet implements Servlet {
	public void init(ServletConfig config) throws ServletException{	}
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		int x = Integer.parseInt(req.getParameter("num"));
		pw.println("<h1>printing your pattern</h1>");
		for(int i=1 ; i<=x ; i++) {
			for(int j=x-i-1 ; j>=0 ; j--) {
				pw.print("..");
			}
			for(int j=1 ; j<=i ; j++) {
				pw.print("*");
			}
			pw.println("<br>");
		}
	}
	public void destroy() {}
	public ServletConfig getServletConfig() {
		return null;
	}
	public String getServletInfo() {
		return "developed by x";
	}

}
