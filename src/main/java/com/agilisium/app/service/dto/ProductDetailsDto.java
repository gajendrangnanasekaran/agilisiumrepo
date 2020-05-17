package com.agilisium.app.service.dto;

import java.util.List;

public class ProductDetailsDto {

	
	
	List<ProductDto> products;

	

	public ProductDetailsDto(List<ProductDto> products) {
		super();
		this.products = products;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	
	
	
	
}
