package com.uma.springboot.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.uma.springboot.entity.Product;
import com.uma.springboot.model.ProductDetails;


@Component
public class ProductMapper {
		
	//This method taking model class As INPUT & RETURN ENTITY CLASS AS OUTPUT
	
	public Product modelToEntityConversion(ProductDetails productDetails)
	{
		//read the data from model class set to entity class
		Product product = new Product();
		product.setProId(productDetails.getProId());
		product.setProName(productDetails.getProName());
		product.setProPrice(productDetails.getProPrice());
		product.setCreateAt(LocalDateTime.now());
		product.setCreatedBy(System.getProperty("user.name"));
		
		
		return product;
		
	}
	
	public List<Product>  modelToEntityListConversion(List<ProductDetails> productDetails)
	{
		List<Product> products = new ArrayList<Product>();
		for(ProductDetails proDetails : productDetails)
		{
			Product product = new Product();
			product.setProId(proDetails.getProId());
			product.setProName(proDetails.getProName());
			product.setProPrice(proDetails.getProPrice());
			product.setCreatedBy(System.getProperty("user.name"));
			product.setCreateAt(LocalDateTime.now());
			products.add(product);
			
		}
		return products;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
