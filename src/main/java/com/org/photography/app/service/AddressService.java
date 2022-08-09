package com.org.photography.app.service;

import com.org.photography.app.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> findAll();

    public Address findById(int theId);

    public void save(Address theAddress);

    public void deleteById(int theId);

    public Address findAddressByCustomerId(int customerId);
}
