package com.sena.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.backend.entity.Category;
import com.sena.backend.exception.ResourceNotFoundException;
import com.sena.backend.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository repository;

	public CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
	}

	public Category save(Category category) {
		category.setId(null);
		return repository.save(category);
	}

	public Category update(Long id, Category category) {
		Category current = findById(id);
		current.setName(category.getName());
		return repository.save(current);
	}

	public void delete(Long id) {
		Category category = findById(id);
		repository.delete(category);
	}
}
