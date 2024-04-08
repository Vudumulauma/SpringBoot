package com.uma.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uma.springboot.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
