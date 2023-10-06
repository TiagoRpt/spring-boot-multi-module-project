package com.example.maven.learning.hellomaven.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	@Value("${spring.message}")
	private String message;

	@GetMapping("/test")
	public void createProduct(){
		System.out.println(message);
	}
}
