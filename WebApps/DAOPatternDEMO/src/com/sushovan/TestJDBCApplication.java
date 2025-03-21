package com.sushovan;

import java.util.Scanner;
//import com.sushovan.Product;
//import com.sushovan.ProductDAOImpl;

public class TestJDBCApplication {
	
	public static void in(ProductDAOImpl pdao) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter pid");
		int pid=sc.nextInt();
		System.out.println("enter pname");
		String pname=sc.next();
		System.out.println("enter price");
		double price=sc.nextDouble();
		Product p=new Product(pid,pname,price);
		int no=pdao.insert(p);
		if(no>=1)
		{
			System.out.println("record is inserted successfully");
		}
		else
		{
			System.out.println("some error ocurred");
		}
		sc.close();
		return;
	}
	public static void up(ProductDAOImpl pdao) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter pid to update the details :");
		int pid=sc.nextInt();
		System.out.println("enter updated pname :");
		String pname=sc.next();
		System.out.println("enter updated price :");
		double price=sc.nextDouble();
		Product p=new Product(pid,pname,price);
		int no=pdao.update(p);
		if(no>=1)
		{
			System.out.println("record is updated successfully");
		}
		else
		{
			System.out.println("some error ocurred");
		}
		sc.close();
		return;
	}
	public static void del_Prod_By_Id(ProductDAOImpl pdao) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter pid to delete the product :");
		int pid=sc.nextInt();
		boolean no=pdao.deleteProductById(pid);
		if(no)
		{
			System.out.println("record is deleted successfully");
		}
		else
		{
			System.out.println("some error ocurred");
		}
		sc.close();
		return;
	}
	public static void del_All_Prod(ProductDAOImpl pdao) {
		pdao.deleteAllProducts();
		System.out.println("all records deleted successfully");
		return;
	}
	public static void ser_Prod_By_Id(ProductDAOImpl pdao) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter pid to search product :");
		int pid=sc.nextInt();
		Product p = pdao.searchProductById(pid);
		if(p==null)
		{
			System.out.println("some error ocurred");
		}
		else
		{
			System.out.println("product ID -"+p.getPid()+"  product NAME - "+p.getPname()+"  product PRICE - "+p.getPrice());
		}
		sc.close();
		return;
	}
	public static void ser_All_Prod(ProductDAOImpl pdao) {
		Product[] p = pdao.searchAllProduct();
		if(p ==null)
		{
			System.out.println("some error ocurred");
		}
		else
		{
			for(int i=0; i<p.length; i++) {
				System.out.println("product ID -"+p[i].getPid()+"  product NAME - "+p[i].getPname()+"  product PRICE - "+p[i].getPrice());
			}
		}
		return;
	}

	
	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		ProductDAOImpl pdao=new ProductDAOImpl();
		
		System.out.println("hello this my first application to connect to database with dao \n here is all of your options>>>>");
		System.out.println("[1]_____Insert Product details >");
		System.out.println("[2]_____Update Product details >");
		System.out.println("[3]_____Delete Product details by Id >");
		System.out.println("[4]_____Delete All Product details >");
		System.out.println("[5]_____Search Product details by Id >");
		System.out.println("[6]_____Search All Product details >");
		System.out.println("[7]_____Exit >");
		
		while(true) {
			//try {
			System.out.println("enter your choice >");			
			String n =sc1.nextLine();
			//catch(Exception ex) {
				//sc.close();
				//System.out.println("error in scanning");
				//return;
			//}
			switch(n){
				case "1":
					in(pdao);
					break;
				case "2":	
					up(pdao);
					break;
				case "3":
					del_Prod_By_Id(pdao);
					break;
				case "4":
					del_All_Prod(pdao);
					break;
				case "5":
					ser_Prod_By_Id(pdao);
					break;
				case "6":
					ser_All_Prod(pdao);
					break;
				case "7":
					sc1.close();
					return;
				default: 
					System.out.println("wrong choice");
			}
		}
	}

}
