package com.sushovan;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAOImpl implements ProductDAO 
{
	public int insert(Product p)
	{
		Connection con=null;
		PreparedStatement pst=null;
		String query="INSERT INTO product VALUES(?,?,?)";
		int no=0;
		try
		{
			con=DBUtility.getConn();
			pst=con.prepareStatement(query);
			pst.setInt(1, p.getPid());
			pst.setString(2, p.getPname());
			pst.setDouble(3,p.getPrice());
			no=pst.executeUpdate();
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			con=null;
			pst=null;
		}
		return no;
	}
	public int update(Product p)
	{
		Connection con=null;
		PreparedStatement pst=null;
		String query="UPDATE product SET PNAME = ?, PRICE = ? WHERE PID = ?;";
		int no=0;
		try
		{
			con=DBUtility.getConn();
			pst=con.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setDouble(2,p.getPrice());
			pst.setInt(3, p.getPid());
			no=pst.executeUpdate();
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			con=null;
			pst=null;
		}
		return no;
	}
	public boolean deleteProductById(int pid)
	{
		Connection con=null;
		PreparedStatement pst=null;
		String query="DELETE FROM product WHERE PID = ?;";
		int no=0;
		try
		{
			con=DBUtility.getConn();
			pst=con.prepareStatement(query);
			pst.setInt(1, pid);
			no=pst.executeUpdate();
			if(no>=1)
				return true;
			else
				return false;
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			con=null;
			pst=null;
		}
		return false;
	}
	public void deleteAllProducts()
	{

		Connection con=null;
		PreparedStatement pst=null;
		
		String query="TRUNCATE TABLE product ;";
		try
		{
			con=DBUtility.getConn();
			pst=con.prepareStatement(query);
			pst.execute();
		}

		catch(ClassNotFoundException | SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			con=null;
			pst=null;
		}
	}
	public Product searchProductById(int pid)
	{
		Connection con=null;
		PreparedStatement pst=null;
		String query="SELECT FROM product WHERE PID = ?";
		Product p = new Product();
		try
		{
			con=DBUtility.getConn();
			pst=con.prepareStatement(query);
			pst.setInt(1, pid);

			ResultSet rs =pst.executeQuery();
			rs.next();
			//p = new Product(rs.getInt("PID"), rs.getString("PNAME"), rs.getDouble("PRICE"));
			p.setPid(rs.getInt("PID"));
			p.setPname(rs.getString("PNAME"));
			p.setPrice(rs.getDouble("PRICE"));
			
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			con=null;
			pst=null;
		}
		return p;
	}
	public Product[] searchAllProduct()
	{
		int i=0;
		Connection con=null;
		PreparedStatement pst=null;
		String query="SELECT * FROM product ";
		Product[] p = null;
		try
		{
			con=DBUtility.getConn();
			pst=con.prepareStatement(query);
			ResultSet rs =pst.executeQuery();
			while(rs.next()) {
				p[i]= new Product();
				p[i].setPid(rs.getInt("PID"));
				p[i].setPname(rs.getString("PNAME"));
				p[i].setPrice(rs.getDouble("PRICE"));
				i+=1;
			}
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			con=null;
			pst=null;
		}
		return p;
	}
}
