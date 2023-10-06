package com.example.maven.learning.hellomaven.repository;

import com.example.maven.learning.hellomaven.dto.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductRepoImplTest {


	@Test
	public void createShouldCreateAProduct(){

		ProductRepo productRepo = new ProductRepoImpl();

		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDescription("It´s Awesome!");
		product.setPrice(800);
		productRepo.create(product);

		Product result = productRepo.read(1);

		assertNotNull(result);
		assertEquals("Iphone",result.getName());
	}
}
