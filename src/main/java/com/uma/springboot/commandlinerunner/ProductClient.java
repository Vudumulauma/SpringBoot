package com.uma.springboot.commandlinerunner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.uma.springboot.entity.Product;
import com.uma.springboot.mapper.ProductMapper;
import com.uma.springboot.model.ProductDetails;
import com.uma.springboot.repository.ProductRepository;

@Component
public class ProductClient implements CommandLineRunner{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper mapper;
	
	//run method automatically calls when the project is started
	@Override
	public void run(String... args) throws Exception {
		
		//model class data : having the values
		
		ProductDetails productDetails = new ProductDetails();
		productDetails.setProId(1001);
		productDetails.setProName("Rice");
		productDetails.setProPrice(240.98);
		
		
		Product product = mapper.modelToEntityConversion(productDetails);
		productRepository.save(product);
		
		ProductDetails p1 = new ProductDetails();
		p1.setProId(121);
		p1.setProName("sugar");
		p1.setProPrice(43);
		
		
		ProductDetails p2 = new ProductDetails();
		p2.setProId(435);
		p2.setProName("oil");
		p2.setProPrice(435);
		
		
		List<ProductDetails> proDetails = List.of(p1,p2);
		
		//Conversion process

		List<Product> produts = mapper.modelToEntityListConversion(proDetails);
		productRepository.saveAll(produts);
		
		Optional<Product> p = productRepository.findById(121);
		if(p.isPresent())
		{
			System.out.println(p);
		}
		else
		{
			System.out.println("Product is not Present");
		}
		
		Long count = productRepository.count();
		System.out.println("The count of the Products is:"+count);
		
		
		
		List<Product> products = productRepository.findAll();
		for(Product pdts : products)
		{
			System.out.println(pdts);
		}
		
		System.out.println(productRepository.existsById(121));
		System.out.println(productRepository.existsById(156));
		
		productRepository.deleteById(121);
		productRepository.deleteAll();
		
		
		
		
	}

}
