package com.sushovan;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/example")
public class ThirdServlet extends HttpServlet {
	public void  doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		pw.print("<h1>this method is called as get method </h1>");
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		PrintWriter pw=res.getWriter();
		pw.print("<h1>this method is called as post method </h1>");
	}
}
