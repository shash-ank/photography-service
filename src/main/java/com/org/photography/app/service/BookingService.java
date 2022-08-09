package com.org.photography.app.service;

import com.org.photography.app.entity.Booking;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface BookingService {
    public List<Booking> findAll();

    public Booking findById(int theId);

    public void save(Booking booking);

    public void deleteById(int theId);

    public List<Booking> getByStatus(String status);

    List<Booking> findAllBookingGreaterOrEqualToDate(Timestamp timestamp);
     public List<Object[]> findByCustomerId(int customerId);


    }
