package com.example.maven.learning.hellomaven.service;

import com.example.maven.learning.hellomaven.dto.Product;
import com.example.maven.learning.hellomaven.repository.ProductRepo;
import com.example.maven.learning.hellomaven.repository.ProductRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{


	private ProductRepo productRepo = new ProductRepoImpl();

	@Override
	public void create(Product product) {
		productRepo.create(product);
	}

	@Override
	public Product read(int id) {
		return productRepo.read(id);
	}

	@Override
	public void update(Product product) {

	}

	@Override
	public void delete(int id) {

	}
}
