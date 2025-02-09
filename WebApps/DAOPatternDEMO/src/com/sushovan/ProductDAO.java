package com.sushovan;

public interface ProductDAO 
{
	int insert(Product p);
	int update(Product p);
	boolean deleteProductById(int pid);
	void deleteAllProducts();
	Product searchProductById(int pid);
	Product[] searchAllProduct();
}