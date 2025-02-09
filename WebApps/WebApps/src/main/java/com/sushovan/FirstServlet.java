package com.sushovan;

import javax.servlet.*;
import java.util.*;
import java.io.*;


public class FirstServlet implements Servlet  {
	static {
		System.out.println("system Class loading");
		//in a java class a static block is a set of instruction that run only once when a 
		//class is loaded into memory.a static block is also called static initialization block 
		//this is because for initializing or setting up the class at run time the keyword static 
		//Indicates that it stands all the instances of the class it is like a 
		//mini global set of instruction since static block is always executed first it does not matter 
		//in which manner it is placed within the class but generally we write a static block inside a class before the constructor definition for better readability.
	}
	public FirstServlet() {
		System.out.println("servlet class Instanciation");	
	}
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method execution");
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html");
		System.out.println("service method execution");
		PrintWriter pw =res.getWriter();
		pw.println("<h1>welcome to advance java</h1>");
		pw.println("<h2>the server time is "+new Date()+"</h2>");
		
	}
	public void destroy() {
		System.out.println("destroy method execution");
	}
	public ServletConfig getServletConfig() {
		return null;
	}
	public String getServletInfo() {
		return "developed by x";
	}
}

