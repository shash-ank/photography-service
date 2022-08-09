package com.org.photography.app.rest;

import com.org.photography.app.entity.Photographer;
import com.org.photography.app.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotographerRestController {
    private PhotographerService photographerService;

    @Autowired
    public PhotographerRestController(PhotographerService thePhotographerService) {
        photographerService = thePhotographerService;
    }

    @GetMapping("/photographers")
    public List<Photographer> findAll() {
        return photographerService.findAll();
    }

    @GetMapping("/photographers/{id}")
    public Photographer getPhotographer(@PathVariable int id) {
        Photographer photographer = photographerService.findById(id);
        if (photographer == null) {
            throw new RuntimeException("Photographer not found -" + id);

        }
        return photographer;
    }

    @PostMapping("/photographers")
    public Photographer addPhotographer(@RequestBody Photographer photographer) {
        photographer.setPhotographerId(0);
        photographerService.save(photographer);
        return photographer;
    }

    @PutMapping("/photographers")
    public Photographer updatePhotographer(@RequestBody Photographer photographer) {
        photographerService.save(photographer);
        return photographer;
    }

    @DeleteMapping("/photographers/{photographerId}")
    public String deletePhotographer(@PathVariable int photographerId) {
        Photographer tempPhotographer = photographerService.findById(photographerId);
        if (tempPhotographer == null) {
            throw new RuntimeException("Photographer id not found "+photographerId);
        }
        photographerService.deleteById(photographerId);
        return "Deleted Photographer with id - "+photographerId;
    }
}
