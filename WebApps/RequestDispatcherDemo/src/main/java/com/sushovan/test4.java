package com.sushovan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/testn")
public class test4  extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<h1>this is the fourth servlet</h1>");
		//if we are sending the request to the first servlet then it will forword the request to the second servlet
		//and 2nd servlet will provide the required response.
	}	

}
