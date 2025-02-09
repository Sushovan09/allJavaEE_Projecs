package com.sushovan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/test1")	//the two servlet should not have same url number else the program should not run  
public class FirstServlet extends HttpServlet{
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			pw.println("<h1> this is the first servlet</h1>");
			//creating request dispatcher object
			RequestDispatcher rd = req.getRequestDispatcher("/test2.jsp");
			rd.forward(req,res);
		}
}
