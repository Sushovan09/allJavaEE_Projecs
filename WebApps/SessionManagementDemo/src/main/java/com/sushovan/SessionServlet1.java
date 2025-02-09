package com.sushovan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

public class SessionServlet1 extends HttpServlet{

		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			
			PrintWriter pw = res.getWriter();
			
			HttpSession hs = req.getSession(); 		//creating a session object
			
			if(hs.isNew())
				pw.println("<h2>New session got Created with session id "+hs.getId()+"</h2>");
			else
				pw.println("<h2>Existing session with session id "+hs.getId()+"</h2>");
			
			String name = req.getParameter("bname");
			String value = req.getParameter("bvalue");
			hs.setAttribute(name, value);
			
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req,res);
			
			
		}
}
