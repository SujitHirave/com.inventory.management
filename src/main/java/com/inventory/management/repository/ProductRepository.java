package com.inventory.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.inventory.management.model.Product;
import com.inventory.management.model.TProduct;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("select NEW  com.inventory.management.model.TProduct (productCategory , SUM(CASE WHEN productTag = 'best seller' THEN 1 ELSE 0 END) AS productSold) from product group by productCategory")
	public List<TProduct> groupByLocation();

}
