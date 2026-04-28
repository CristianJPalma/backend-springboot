package com.sena.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
