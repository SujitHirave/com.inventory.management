package com.inventory.management.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventory.management.model.Product;
import com.inventory.management.model.TProduct;
import com.inventory.management.service.ProductService;

/**
 * 
 * controller for Product CRUD functionalities
 *
 */
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false"   )
@RestController
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

	
	@Autowired
	private ProductService productService;
	
	//addProduct
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
	    LOG.info("ProductController - addProduct");
		Product newProduct = productService.saveProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct,HttpStatus.CREATED);
		return responseEntity;
	}
	
	//fetchAllProducts
	@GetMapping("/viewproduct")
	public List<Product> fetchAllProducts(){
	    LOG.info("ProductController - fetchAllProducts");
		List<Product> products = productService.getAllProducts();
		return products;
	}
	
	//fetchProductById
	@GetMapping("/getproductbyid/{productId}")
	public ResponseEntity<Object> fetchProductById(@PathVariable int productId) {
	    LOG.info("ProductController - fetchProductById");
		//try {
		Product product = productService.getProductById(productId);
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
		return responseEntity;
		//}
	/*	catch(ProductNotFoundException e) {
			ResponseEntity<Object> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			return responseEntity;
		}*/
	}
	
	//deleteProductById
	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity deleteProductById(@PathVariable int productId) {
	    LOG.info("ProductController - deleteProductById");

	//try {      //if dont want to include than  we have to make a new separate class for defining exception
		productService.deleteProduct(productId);
	    return 	new ResponseEntity<>(productId,HttpStatus.OK);

	//}	//here we are taking GlobalExceptionHandller class
	/*catch(ProductNotFoundException e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
		
		
	}*/
	}
	 
	//modifyProduct
	@PutMapping("/editproduct")
	public ResponseEntity<Product> modifyProduct(@RequestBody Product product){
	    LOG.info("ProductController - modifyProduct");
		Product updatedProduct = productService.updateProduct(product);
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(updatedProduct,HttpStatus.OK);
		return responseEntity;

   }
	//groupByCategory
	 @GetMapping("/groupcatg")
	   public ResponseEntity<List<TProduct>> groupByCategory() {
		    LOG.info("ProductController-groupByCategory");
	      List<TProduct> catg = productService.groupByCategory();
	      return ResponseEntity.ok().body(catg);
	   }

}
