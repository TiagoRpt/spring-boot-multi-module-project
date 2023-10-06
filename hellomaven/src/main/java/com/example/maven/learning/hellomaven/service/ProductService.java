package com.example.maven.learning.hellomaven.service;

import com.example.maven.learning.hellomaven.dto.Product;

public interface ProductService {

	void create(Product product);

	Product read(int id);

	void update(Product product);

	void delete(int id);
}
