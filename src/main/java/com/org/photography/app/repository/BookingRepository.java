package com.org.photography.app.repository;

import com.org.photography.app.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface BookingRepository  extends JpaRepository<Booking,Integer> {
    List<Booking> getByStatus(String status);
    @Query(
            value = "SELECT * FROM Booking b WHERE b.booking_date_and_time >= ?1",
            nativeQuery = true)
    List<Booking> findAllBookingGreaterOrEqualToDate(Timestamp timestamp);
    @Query(value="Select e.event_name,b.booking_date_and_time, b.booking_status from  Booking b , eventtype e where b.customer_id=?1 and b.event_id = e.event_id",nativeQuery = true)
    List<Object[]> findByCustomerId(int customerId);
}
