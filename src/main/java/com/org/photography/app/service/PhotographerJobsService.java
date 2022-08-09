package com.org.photography.app.service;

import com.org.photography.app.entity.PhotographerJobs;

import java.sql.Date;
import java.util.List;

public interface PhotographerJobsService {
    public List<PhotographerJobs> findAll();

    public PhotographerJobs findById(int theId);

    public void save(PhotographerJobs thePhotographerJobs);

    public void deleteById(int theId);

    List<PhotographerJobs> findByPhotographerId(int photographerId, Date date);
    public List<Object[]> findCustomerDetailsByPhotographerId(int photographerId, Date date);
}
