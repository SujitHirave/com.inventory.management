package com.inventory.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.inventory.management.exception.ProductNotFoundException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.inventory.management.model.Product;
import com.inventory.management.repository.ProductRepository;
import com.inventory.management.service.impl.ProductServiceImpl;

@SpringBootTest
public class ProductServiceImplTest {
	@InjectMocks
    ProductServiceImpl productServiceImpl = new ProductServiceImpl();

 

   @Mock
    ProductRepository productRepository;    

 

   @Test
    public void testGetProductById() {
       Product product = new Product();
        product.setProductId(1);
        product.setProductName("Shirt");
        product.setProductPrice(500);
        product.setProductDescription("blue shirt in cotton cloth");
        product.setProductCategory("Faishon");
        product.setProductSize("medium");
        product.setProductTag("abcd");
        product.setProductImageUrl("jgufyf");

       Optional<Product> optionalProduct = Optional.of(product);
       when(productRepository.findById(1)).thenReturn(optionalProduct);
       Product productObj = productServiceImpl.getProductById(1);
       assertEquals("Shirt",productObj.getProductName());
        assertEquals(500,productObj.getProductPrice());        
    }

   @Test
   public void testGetProductByIdException() {

 

      when(productRepository.findById(1020)).thenThrow(ProductNotFoundException.class);
      assertThrows(ProductNotFoundException.class,()->productServiceImpl.getProductById(1020));
   }

   @Test
   public void testGetAllProducts() {

 

      Product product = new Product();
      product.setProductId(10);
      product.setProductName("Bulb");
      product.setProductPrice(250);
      product.setProductDescription("yellow bulb");
      product.setProductCategory("Electric");
      product.setProductSize("small");
      product.setProductTag("xyz");
      product.setProductImageUrl("ttyu");

 

      Product product2 = new Product();
      product2.setProductId(20);
      product2.setProductName("Duck");
      product2.setProductPrice(5000);
      product2.setProductDescription("White fur duck with dark blue eyes");
      product2.setProductCategory("Toys");
      product2.setProductSize("Large");
      product2.setProductTag("pqrs");
      product2.setProductImageUrl("ihugu");

 

      Product product3 = new Product();
      product3.setProductId(30);
      product3.setProductName("Jeans");
      product3.setProductPrice(800);
      product3.setProductDescription("black jeans in cotton cloth");
      product3.setProductCategory("Faishon");
      product3.setProductSize("Large");
      product3.setProductTag("mnop");
      product3.setProductImageUrl("eerdr");

 

      List<Product> productList = new ArrayList<>();
       productList.add(product3);
       productList.add(product2);
       productList.add(product);

 

      when(productRepository.findAll()).thenReturn(productList);
      List<Product> products = productServiceImpl.getAllProducts();
      assertEquals(3, products.size());
   }

   @Test
   public void testDeleteProduct() {

 

      Product product = new Product();
      product.setProductId(8);
      product.setProductName("Tops-Tees");
      product.setProductPrice(500);
      product.setProductDescription("All tops and tees in cotton cloth");
      product.setProductCategory("Faishon");
      product.setProductSize("Small");
      product.setProductTag("mnop");
      product.setProductImageUrl("lloik");

 

      Optional<Product> optionalProduct = Optional.of(product);
      when(productRepository.findById(8)).thenReturn(optionalProduct);
      doNothing().when(productRepository).deleteById(8);
      productServiceImpl.deleteProduct(8);
      verify(productRepository,times(1)).findById(8);
       verify(productRepository,times(1)).deleteById(8);
   }

}

