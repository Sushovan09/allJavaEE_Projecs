package com.sushovan;

import java.io.*;
import javax.servlet.*;
import javax.servlet.HttpConstraintElement.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/info")
public class ClientServerInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h2>Client IP address :"+req.getRemoteAddr()+"</h2>");
		out.println("<h2>Client host name :"+req.getRemoteHost()+"</h2>");
		out.println("<h2>Client port number :"+req.getRemotePort()+"</h2>");
		out.println("<h2>Client Server name :"+req.getServerName()+"</h2>");
		out.println("<h2>Client Server port :"+req.getServerPort()+"</h2>");
	}
}
