package com.org.photography.app.service;

import com.org.photography.app.entity.Booking;
import com.org.photography.app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository theBookingRepository) {
        bookingRepository = theBookingRepository;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(int theId) {
        Optional<Booking> result = bookingRepository.findById(theId);

        Booking theBooking = null;

        if (result.isPresent()) {
            theBooking = result.get();
        }
        else {
            // we didn't find the Booking
            throw new RuntimeException("Did not find Booking id - " + theId);
        }

        return theBooking;
    }

    @Override
    public void save(Booking theBooking) {
        bookingRepository.save(theBooking);
    }

    @Override
    public void deleteById(int theId) {
        bookingRepository.deleteById(theId);
    }

    @Override
    public List<Booking> getByStatus(String status) {
        return bookingRepository.getByStatus(status);
    }
    @Override
    public List<Booking> findAllBookingGreaterOrEqualToDate(Timestamp timestamp){
       return bookingRepository.findAllBookingGreaterOrEqualToDate(timestamp);
    }
@Override
    public List<Object[]> findByCustomerId(int customerId){
        return bookingRepository.findByCustomerId(customerId);
    }

}
