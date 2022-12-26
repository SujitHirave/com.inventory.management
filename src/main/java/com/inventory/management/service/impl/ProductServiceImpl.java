package com.inventory.management.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.inventory.management.exception.ProductNotFoundException;
import com.inventory.management.model.Product;
import com.inventory.management.model.TProduct;
import com.inventory.management.repository.ProductRepository;
import com.inventory.management.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * Service forProductService functionalities
 *
 */

@Service
public class ProductServiceImpl implements ProductService {
	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	
	@Autowired
	private ProductRepository productRepository;
	
	//saveProduct
	@Override
	public Product saveProduct(Product product) {
		LOG.info("ProductServiceImpl-saveProduct");
		Product newProduct = productRepository.save(product);
		return newProduct;
	}
	
	//getAllProducts
	@Override
	public List<Product> getAllProducts(){
		LOG.info("ProductServiceImpl-getAllProducts");
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	//getProductById
	@Override
	public Product getProductById(int productId) {
		LOG.info("ProductServiceImpl-getProductById");
		Optional<Product> optionalProduct = productRepository.findById(productId);
//		if(optionalProduct.isEmpty()) {
//			throw new ProductNotFoundException("Product not existing with id: "+productId);
//		}
		Product product = optionalProduct.get();
		return product;
	}
	
	//deleteProduct
	@Override
	public void deleteProduct(int productId) {
		LOG.info("ProductServiceImpl-deleteProduct");
		Optional<Product> optionalProduct = productRepository.findById(productId);
//		if(optionalProduct.isEmpty()) {
//			throw new ProductNotFoundException("Product not existing with id: "+productId);
//		}
		productRepository.deleteById(productId);
	}
	
	//updateProduct
	@Override
	public Product updateProduct(Product product) {
		LOG.info("ProductServiceImpl-updateProduct");
		Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
//		if(optionalProduct.isEmpty()) {
//			throw new ProductNotFoundException("Product not existing with id: "+product);
//		}
		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}
	
	//groupByCategory
	@Override
	@Transactional
	public List<TProduct> groupByCategory() {
		LOG.info("ProductServiceImpl-groupByCategory");
//		System.out.println(productRepository.groupByProduct());
		return productRepository.groupByLocation();
		
	}

}
