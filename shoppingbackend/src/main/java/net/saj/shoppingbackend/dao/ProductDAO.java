package net.saj.shoppingbackend.dao;

import java.util.List;

import net.saj.shoppingbackend.dto.Product;

public interface ProductDAO {

	List<Product> list();
	Product get(int productId);
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	// business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);


}
