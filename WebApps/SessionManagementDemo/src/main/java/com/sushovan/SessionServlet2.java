package com.sushovan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;

@WebServlet("/sky2")
public class SessionServlet2  extends HttpServlet{
	
			public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
				
				res.setContentType("text/html");
				
				PrintWriter pw = res.getWriter();
				
				HttpSession hs = req.getSession(); 		//check any session exist or not
				
				if(hs==null)
					pw.println("<h2>No session infotmation is available</h2>");
				else {
					Enumeration e = hs.getAttributeNames();
					pw.println("<table border=2><tr><th>SessionAttribute Name</th><th>SessionAttribute Value</th><tr>");
					//While
					//String name = req.getParameter("bname");
					//String value = req.getParameter("bvalue");
					//hs.setAttribute(name, value);
				
					RequestDispatcher rd = req.getRequestDispatcher("Login.html");
					rd.include(req,res);
					
				}
				
			}
}
