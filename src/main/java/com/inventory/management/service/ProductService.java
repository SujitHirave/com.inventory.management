package com.inventory.management.service;

import java.util.List;

import com.inventory.management.model.Product;
import com.inventory.management.model.TProduct;

public interface ProductService {

	   public Product saveProduct(Product product);
		
		public List<Product> getAllProducts();
		
		public Product getProductById(int productId);
		
		public void deleteProduct(int productId);
		
		public Product updateProduct(Product product);
		
		public List<TProduct> groupByCategory();


}
