package com.example.maven.learning.hellomaven.repository;

import com.example.maven.learning.hellomaven.dto.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo {

	void create(Product product);

	Product read(int id);

	void update(Product product);

	void delete(int id);
}
