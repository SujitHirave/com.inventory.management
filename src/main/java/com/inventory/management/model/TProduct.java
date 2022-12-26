package com.inventory.management.model;


import java.io.*;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;


public class TProduct {

	
	private String productCategory;
	private Long productSold;
//	private int vaccinationc;
//	private String projectName;

	public TProduct() {
		super();
	}

	public TProduct(String productCategory, Long productSold) {
		super();
		this.productCategory = productCategory;
		this.productSold = productSold;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Long getProductSold() {
		return productSold;
	}

	public void setProductSold(Long productSold) {
		this.productSold = productSold;
	}

	@Override
	public String toString() {
		return "TProduct [productCategory=" + productCategory + ", productSold=" + productSold + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(productCategory, productSold);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TProduct other = (TProduct) obj;
		return Objects.equals(productCategory, other.productCategory) && Objects.equals(productSold, other.productSold);
	}
    
	
}



