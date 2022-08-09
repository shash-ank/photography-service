package com.org.photography.app.service;

import com.org.photography.app.entity.PhotographerNotifications;
import com.org.photography.app.repository.PhotographerNotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class PhotographerNotificationsServiceImpl implements PhotographerNotificationsService {
    private PhotographerNotificationsRepository photographerNotificationsRepository;

    @Autowired
    public PhotographerNotificationsServiceImpl(PhotographerNotificationsRepository thePhotographerNotificationsRepository) {
        photographerNotificationsRepository = thePhotographerNotificationsRepository;
    }

    @Override
    public List<PhotographerNotifications> findAll() {
        return photographerNotificationsRepository.findAll();
    }

    @Override
    public PhotographerNotifications findById(int theId) {
        Optional<PhotographerNotifications> result = photographerNotificationsRepository.findById(theId);

        PhotographerNotifications thePhotographerNotifications = null;

        if (result.isPresent()) {
            thePhotographerNotifications = result.get();
        }
        else {
            // we didn't find the PhotographerNotifications
            throw new RuntimeException("Did not find PhotographerNotifications id - " + theId);
        }

        return thePhotographerNotifications;
    }

    @Override
    public void save(PhotographerNotifications thePhotographerNotifications) {
        photographerNotificationsRepository.save(thePhotographerNotifications);
    }



    @Override
    public List<Object[]> findAllNotifications(Integer photographerId) {
        return photographerNotificationsRepository.findAllNotifications(photographerId);
    }

    @Override
    public void deleteById(int theId) {
        photographerNotificationsRepository.deleteById(theId);
    }

    @Override
    public void deleteAllByBookingId(int bookingId) {
        photographerNotificationsRepository.deleteAllByBookingId(bookingId);
    }
}
