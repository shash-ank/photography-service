package com.org.photography.service;

import com.org.photography.app.entity.Address;
import com.org.photography.app.entity.Customer;
import com.org.photography.app.repository.AddressRepository;
import com.org.photography.app.repository.CustomerRepository;
import com.org.photography.app.service.AddressService;
import com.org.photography.app.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@SpringBootTest(classes = com.org.photography.app.PhotographyServiceApplication.class)
public class AddressServiceTest {
    @Autowired
    private AddressService  addressService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @MockBean
    private AddressRepository addressRepository;
    @Test
    public void findAddressByCustomerId(){

        Customer customer = customerService.findById(1);

        Address address = new Address("India","500084","Himagiri nagar","4-9-4", customer,"Saibaba temple","Hyderabad","Telangana");
            when(addressRepository.findAddressByCustomerId(1)).thenReturn(address);
            assertEquals(address,addressService.findAddressByCustomerId(1));

    }

    @Test
    public void findAddressById(){
        Customer customer = customerService.findById(1);
        System.out.println(customer.toString());
        Address address = new Address("India","500084","Himagiri nagar","4-9-4", customer,"Saibaba temple","Hyderabad","Telangana");
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));
        assertEquals(address,addressService.findById(1));
    }
}
