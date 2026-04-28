package com.sena.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.backend.entity.Customer;
import com.sena.backend.exception.ResourceNotFoundException;
import com.sena.backend.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository repository;

	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Customer findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
	}

	public Customer save(Customer customer) {
		customer.setId(null);
		return repository.save(customer);
	}

	public Customer update(Long id, Customer customer) {
		Customer current = findById(id);
		current.setFullName(customer.getFullName());
		current.setEmail(customer.getEmail());
		return repository.save(current);
	}

	public void delete(Long id) {
		Customer customer = findById(id);
		repository.delete(customer);
	}
}
