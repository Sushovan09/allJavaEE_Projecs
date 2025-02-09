package com.sushovan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/testm")
public class test3 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<h1> this is the third servlet before include</h1>");
		//creating request dispatcher object
		RequestDispatcher rd = req.getRequestDispatcher("/testn");
		rd.include(req,res);
		pw.println("<h1> this is the third servlet after responce coming from fourth servlet we are in third servlet</h1>");
	}	
}
