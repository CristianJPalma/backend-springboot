package com.sena.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.backend.entity.Product;
import com.sena.backend.exception.ResourceNotFoundException;
import com.sena.backend.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
	}

	public Product save(Product product) {
		product.setId(null);
		return repository.save(product);
	}

	public Product update(Long id, Product product) {
		Product current = findById(id);
		current.setName(product.getName());
		current.setDescription(product.getDescription());
		current.setPrice(product.getPrice());
		current.setStock(product.getStock());
		return repository.save(current);
	}

	public void delete(Long id) {
		Product product = findById(id);
		repository.delete(product);
	}
}
