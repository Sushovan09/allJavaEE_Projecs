package com.sushovan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/test12")
public class ValidateServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String name = req.getParameter("uname");
		String pwd = req.getParameter("password");
		if(name.equals("sushovan") && pwd.equals("1234")) {
			ServletContext sc = getServletContext();
			RequestDispatcher rd = req.getRequestDispatcher("/Inbox.jsp");
			rd.forward(req,res);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("/Error.jsp");
			rd.forward(req,res);
		}
		
	}
		
}
