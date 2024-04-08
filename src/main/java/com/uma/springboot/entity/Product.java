package com.uma.springboot.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Product {
	
     	@Id
		private int proId;
		
		private String proName;
		private double proPrice;
		
		
		//private Date createAt;
		//private String createBy;
		
		@CreatedDate
		private LocalDateTime createAt;
		
		
		@CreatedBy
		private String createdBy;
		
	}

	



