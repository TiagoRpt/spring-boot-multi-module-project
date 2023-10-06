package com.example.hello.maven.web.hellomavenweb.controller;

import com.example.maven.learning.hellomaven.dto.Product;
import com.example.maven.learning.hellomaven.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<Void> createProduct(@RequestBody Product product){
		productService.create(product);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}


	@GetMapping("/product/{id}")
	public ResponseEntity<Product> createProduct(@PathVariable int id){
		Product product = productService.read(id);

		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
}
