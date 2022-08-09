package com.org.photography.app.service;

import com.org.photography.app.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    public List<Customer> findAll();

    public Customer findById(int theId);

    public void save(Customer theCustomer);

    public void deleteById(int theId);
    public Boolean existsByUsername (String username);
    public Boolean existsByEmail(String email);
    Optional<Customer> findByUsername(String username);
}
