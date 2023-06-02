package com.feignclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	Integer  productId;
	String name;
	String category;
	String brand;
	double price;
  
  
}
