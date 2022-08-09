package com.org.photography.app.service;

import com.org.photography.app.entity.Address;
import com.org.photography.app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository theAddressRepository) {
        addressRepository = theAddressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(int theId) {
        Optional<Address> result = addressRepository.findById(theId);

        Address theAddress = null;

        if (result.isPresent()) {
            theAddress = result.get();
        }
        else {
            // we didn't find the Address
            throw new RuntimeException("Did not find Address id : " + theId);
        }

        return theAddress;
    }

    @Override
    public void save(Address theAddress) {
        addressRepository.save(theAddress);
    }

    @Override
    public void deleteById(int theId) {
        addressRepository.deleteById(theId);
    }



    @Override
    public Address findAddressByCustomerId(int customerId) {
        return addressRepository.findAddressByCustomerId(customerId);
    }
}
