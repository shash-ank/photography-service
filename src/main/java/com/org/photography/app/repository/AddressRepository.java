package com.org.photography.app.repository;

import com.org.photography.app.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository  extends JpaRepository<Address,Integer> {
    @Query(value = "select address_id, customer_id, country, pincode, house_no, area, landmark, city, state  from address where customer_id=?1",nativeQuery = true)
    public Address findAddressByCustomerId(int customerId);
}
