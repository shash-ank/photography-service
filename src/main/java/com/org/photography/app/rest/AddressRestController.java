package com.org.photography.app.rest;

import com.org.photography.app.entity.Address;
import com.org.photography.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressRestController {
    private AddressService addressService;

    @Autowired
    public AddressRestController(AddressService theAddressService) {
        addressService = theAddressService;
    }

    @GetMapping("/addresses")
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/addresses/{id}")
    public Address getAddressByCustomerId(@PathVariable int id) {
        Address address = addressService.findAddressByCustomerId(id);
        if (address == null) {
            throw new RuntimeException("Address not found -" + id);

        }
        return address;
    }

    @PostMapping("/addresses")
    public Address addAddress(@RequestBody Address address) {
        address.setAddressId(0);
        addressService.save(address);
        return address;
    }

    @PutMapping("/addresses")
    public Address updateAddress(@RequestBody Address address) {
        addressService.save(address);
        return address;
    }

    @DeleteMapping("/addresses/{addressId}")
    public String deleteAddress(@PathVariable int addressId) {
        Address tempAddress = addressService.findById(addressId);
        if (tempAddress == null) {
            throw new RuntimeException("Address id not found "+addressId);
        }
        addressService.deleteById(addressId);
        return "Deleted Address with id - "+addressId;
    }
}
