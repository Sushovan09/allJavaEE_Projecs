package com.sushovan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility 
{
	private static String URL="jdbc:mysql://localhost:3306/store";
	private static String Username="root";
	private static String Password="1234";
	private static Connection con;
	public static Connection getConn() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		if(con==null)
		{
			con=DriverManager.getConnection(URL,Username,Password);
		}
		return con;
	}
}