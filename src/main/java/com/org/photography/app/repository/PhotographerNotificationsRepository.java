package com.org.photography.app.repository;

import com.org.photography.app.entity.Photographer;
import com.org.photography.app.entity.PhotographerNotifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PhotographerNotificationsRepository extends JpaRepository<PhotographerNotifications, Integer> {
    //select custname,address,event,timestamp >currenttimestamp
    @Query(value="select distinct c.customer_id, b.booking_id, e.event_id,p.photographer_id, c.first_name,c.last_name, a.house_no, a.area, a.landmark, a.pincode,a.city, e.event_name, b.booking_date_and_time from \n" +
            "photographer_notifications p, address a, eventtype e, customer c,  booking b where b.customer_id = c.customer_id and \n" +
            "b.event_id = e.event_id and a.customer_id = c.customer_id and  p.photographer_id=?1\n" +
            " and b.booking_status =\"pending\"\n" +
            " and b.booking_date_and_time >= CURRENT_TIMESTAMP", nativeQuery = true)

    List<Object[]> findAllNotifications(Integer photographerId);
    @Modifying
    @Query(value="delete from photographer_notifications  where booking_id=?1",nativeQuery = true)
    public void deleteAllByBookingId(int bookingId);
}
//select  c.customer_name, a.address_id, event,, timestamp from photographer_notification p inner join booking b inner join customer c inner join address a  where photographer_id=:photographerid and booking status ="pending"