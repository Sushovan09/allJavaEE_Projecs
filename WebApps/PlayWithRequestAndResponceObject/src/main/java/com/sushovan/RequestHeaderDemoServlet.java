package com.sushovan;

import java.io.*;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
//import java.util*;

@WebServlet("/requestHeader")
public class RequestHeaderDemoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>Request Header Information </h1><br>");
		out.println("<table border = 2><tr><th>Header Name</tr></th>");
		Enumeration<String> e=req.getHeaderNames();
		while(e.hasMoreElements()) {
			String headername=(String)e.nextElement();
			String headervalue=req.getHeader(headername);
			out.println("<tr><td>"+headername+"</td><td>"+headervalue+"</td></tr>");
		}
		out.println("</table>");
	}
}
