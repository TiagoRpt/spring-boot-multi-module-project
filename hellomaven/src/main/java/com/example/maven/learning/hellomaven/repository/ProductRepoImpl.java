package com.example.maven.learning.hellomaven.repository;

import com.example.maven.learning.hellomaven.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


public class ProductRepoImpl implements ProductRepo{

	Map<Integer,Product> products = new HashMap<>();

	@Override
	public void create(Product product) {
		products.put(product.getId(),product);
	}

	@Override
	public Product read(int id) {
		return products.get(id);
	}

	@Override
	public void update(Product product) {

	}

	@Override
	public void delete(int id) {

	}
}
