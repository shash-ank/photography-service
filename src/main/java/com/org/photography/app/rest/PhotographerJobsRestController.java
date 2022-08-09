package com.org.photography.app.rest;

import com.org.photography.app.entity.PhotographerJobs;
import com.org.photography.app.service.PhotographerJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhotographerJobsRestController {
    private PhotographerJobsService photographerJobsService;

    @Autowired
    public PhotographerJobsRestController(PhotographerJobsService thePhotographerJobsService) {
        photographerJobsService = thePhotographerJobsService;
    }

    @GetMapping("/photographerJobs")
    public List<PhotographerJobs> findAll() {
        return photographerJobsService.findAll();
    }

    @GetMapping("/photographerJobses/{id}")
    public PhotographerJobs getPhotographerJobs(@PathVariable int id) {
        PhotographerJobs photographerJobs = photographerJobsService.findById(id);
        if (photographerJobs == null) {
            throw new RuntimeException("PhotographerJobs not found -" + id);

        }
        return photographerJobs;
    }

    @PostMapping("/photographerJobs")
    public PhotographerJobs addPhotographerJobs(@RequestBody PhotographerJobs photographerJobs) {
        photographerJobs.setJobId(0);
        photographerJobsService.save(photographerJobs);
        return photographerJobs;
    }

    @PutMapping("/photographerJobs")
    public PhotographerJobs updatePhotographerJobs(@RequestBody PhotographerJobs photographerJobs) {
        photographerJobsService.save(photographerJobs);
        return photographerJobs;
    }

    @DeleteMapping("/photographerJobs/{photographerJobId}")
    public String deletePhotographerJobs(@PathVariable int photographerJobId) {
        PhotographerJobs tempPhotographerJobs = photographerJobsService.findById(photographerJobId);
        if (tempPhotographerJobs == null) {
            throw new RuntimeException("PhotographerJobs id not found "+photographerJobId);
        }
        photographerJobsService.deleteById(photographerJobId);
        return "Deleted photographerJobs with id - "+photographerJobId;
    }
}
