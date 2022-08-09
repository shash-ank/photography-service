package com.org.photography.app.rest;

import com.org.photography.app.entity.PhotographerNotifications;
import com.org.photography.app.service.PhotographerNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotographerNotificationsRestController {
    private PhotographerNotificationsService photographerNotificationsService;

    @Autowired
    public PhotographerNotificationsRestController(PhotographerNotificationsService thePhotographerNotificationsService) {
        photographerNotificationsService = thePhotographerNotificationsService;
    }

    @GetMapping("/photographerNotifications")
    public List<PhotographerNotifications> findAll() {
        return photographerNotificationsService.findAll();
    }

    @GetMapping("/photographerNotifications/{id}")
    public PhotographerNotifications getPhotographerNotifications(@PathVariable int id) {
        PhotographerNotifications photographerNotifications = photographerNotificationsService.findById(id);
        if (photographerNotifications == null) {
            throw new RuntimeException("PhotographerNotifications not found -" + id);

        }
        return photographerNotifications;
    }

    @PostMapping("/photographerNotifications")
    public PhotographerNotifications addPhotographerNotifications(@RequestBody PhotographerNotifications photographerNotifications) {
        photographerNotifications.setNotificationId(0);
        photographerNotificationsService.save(photographerNotifications);
        return photographerNotifications;
    }

    @PutMapping("/photographerNotifications")
    public PhotographerNotifications updatePhotographerNotifications(@RequestBody PhotographerNotifications photographerNotifications) {
        photographerNotificationsService.save(photographerNotifications);
        return photographerNotifications;
    }

    @DeleteMapping("/photographerNotifications/{photographerNotificationsId}")
    public String deletePhotographerNotifications(@PathVariable int photographerNotificationsId) {
        PhotographerNotifications tempPhotographerNotifications = photographerNotificationsService.findById(photographerNotificationsId);
        if (tempPhotographerNotifications == null) {
            throw new RuntimeException("PhotographerNotifications id not found "+photographerNotificationsId);
        }
        photographerNotificationsService.deleteById(photographerNotificationsId);
        return "Deleted PhotographerNotifications with id - "+photographerNotificationsId;
    }
}
