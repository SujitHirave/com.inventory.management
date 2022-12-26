package com.inventory.management.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "product")
public class Product {
	@Id
	@Column(name = "productId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	

	@Column(name = "productName", length = 50)
	private String productName;

	@Column(name = "productPrice", length = 10)
	private double productPrice;

	@Column(name = "productDescription", length = 40)
	private String productDescription;


	@Column(name = "productTag", length = 20)
	private String productTag;
	
	@Column(name = "productSize", length = 20)
	private String productSize;
	
	@Column(name="productImageUrl")
	private String productImageUrl;

//	@ManyToOne
//	@JoinColumn(name = "catid")
	@Column(name="productCategory")
	private String productCategory;
	
	
	public Product() {
		super();
	}


	public Product(int productId, String productName, double productPrice, String productDescription, String productTag,
			String productSize, String productImageUrl, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productTag = productTag;
		this.productSize = productSize;
		this.productImageUrl = productImageUrl;
		this.productCategory = productCategory;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public String getProductTag() {
		return productTag;
	}


	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}


	public String getProductSize() {
		return productSize;
	}


	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}


	public String getProductImageUrl() {
		return productImageUrl;
	}


	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDescription=" + productDescription + ", productTag=" + productTag + ", productSize="
				+ productSize + ", productImageUrl=" + productImageUrl + ", productCategory=" + productCategory + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(productCategory, productDescription, productId, productImageUrl, productName, productPrice,
				productSize, productTag);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productCategory, other.productCategory)
				&& Objects.equals(productDescription, other.productDescription) && productId == other.productId
				&& Objects.equals(productImageUrl, other.productImageUrl)
				&& Objects.equals(productName, other.productName)
				&& Double.doubleToLongBits(productPrice) == Double.doubleToLongBits(other.productPrice)
				&& Objects.equals(productSize, other.productSize) && Objects.equals(productTag, other.productTag);
	}


	
	

}
