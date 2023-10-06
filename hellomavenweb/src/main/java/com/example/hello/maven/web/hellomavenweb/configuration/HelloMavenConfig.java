package com.example.hello.maven.web.hellomavenweb.configuration;

import com.example.maven.learning.hellomaven.repository.ProductRepo;
import com.example.maven.learning.hellomaven.repository.ProductRepoImpl;
import com.example.maven.learning.hellomaven.service.ProductService;
import com.example.maven.learning.hellomaven.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloMavenConfig {

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl();
	}

	@Bean
	public ProductRepo productRepo() {
		return new ProductRepoImpl();
	}
}
