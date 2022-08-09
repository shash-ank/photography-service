package com.org.photography.app.service;

//public class CustomerServiceImpl {
//
//}


import java.util.List;
import java.util.Optional;

import com.org.photography.app.entity.Customer;
import com.org.photography.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository CustomerRepository;

    @Autowired
    public CustomerServiceImpl(com.org.photography.app.repository.CustomerRepository theCustomerRepository) {
        CustomerRepository = theCustomerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return CustomerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = CustomerRepository.findById(theId);

        Customer theCustomer = null;

        if (result.isPresent()) {
            theCustomer = result.get();
        }
        else {
            // we didn't find the Customer
            throw new RuntimeException("Did not find Customer id - " + theId);
        }

        return theCustomer;
    }

    @Override
    public void save(Customer theCustomer) {
        CustomerRepository.save(theCustomer);
    }

    @Override
    public void deleteById(int theId) {
        CustomerRepository.deleteById(theId);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return CustomerRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return CustomerRepository.existsByEmail(email);
    }

    @Override
    public Optional<Customer> findByUsername(String username) {
        return CustomerRepository.findByUsername(username);
    }
}






