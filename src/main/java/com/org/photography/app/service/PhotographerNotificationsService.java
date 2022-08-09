package com.org.photography.app.service;

import com.org.photography.app.entity.PhotographerNotifications;

import java.util.List;

public interface PhotographerNotificationsService {
    public List<PhotographerNotifications> findAll();

    public PhotographerNotifications findById(int theId);

    public void save(PhotographerNotifications thePhotographerNotifications);

    public void deleteById(int theId);


    List<Object[]> findAllNotifications(Integer photographerId);


   public void deleteAllByBookingId(int bookingId);
}

