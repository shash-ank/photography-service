package com.org.photography.app.service;

import com.org.photography.app.entity.PhotographerJobs;
import com.org.photography.app.repository.PhotographerJobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PhotographerJobsServiceImpl implements PhotographerJobsService {
    private PhotographerJobsRepository photographerJobsRepository;

    @Autowired
    public PhotographerJobsServiceImpl(PhotographerJobsRepository thePhotographerJobsRepository) {
        photographerJobsRepository = thePhotographerJobsRepository;
    }

    @Override
    public List<PhotographerJobs> findAll() {
        return photographerJobsRepository.findAll();
    }

    @Override
    public PhotographerJobs findById(int theId) {
        Optional<PhotographerJobs> result = photographerJobsRepository.findById(theId);

        PhotographerJobs thePhotographerJobs = null;

        if (result.isPresent()) {
            thePhotographerJobs = result.get();
        }
        else {
            // we didn't find the PhotographerJobs
            throw new RuntimeException("Did not find PhotographerJobs id - " + theId);
        }

        return thePhotographerJobs;
    }

    @Override
    public void save(PhotographerJobs thePhotographerJobs) {
        photographerJobsRepository.save(thePhotographerJobs);
    }
    @Override
    public void deleteById(int theId) {
        photographerJobsRepository.deleteById(theId);
    }
    @Override
    public List<PhotographerJobs> findByPhotographerId(int photographerId, Date date){

        return photographerJobsRepository.findByPhotographerId(photographerId, date);


    }

    public List<Object[]> findCustomerDetailsByPhotographerId(int photographerId, Date date){
        return photographerJobsRepository.findCustomerDetailsByPhotographerId(photographerId,date);
    }

}
