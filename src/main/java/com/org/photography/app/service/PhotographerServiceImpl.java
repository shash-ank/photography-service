package com.org.photography.app.service;

import com.org.photography.app.entity.Photographer;
import com.org.photography.app.repository.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PhotographerServiceImpl implements PhotographerService {
    private PhotographerRepository photographerRepository;

    @Autowired
    public PhotographerServiceImpl(PhotographerRepository thePhotographerRepository) {
        photographerRepository = thePhotographerRepository;
    }

    @Override
    public List<Photographer> findAll() {
        return photographerRepository.findAll();
    }

    @Override
    public Photographer findById(int theId) {
        Optional<Photographer> result = photographerRepository.findById(theId);

        Photographer thePhotographer = null;

        if (result.isPresent()) {
            thePhotographer = result.get();
        }
        else {
            // we didn't find the Photographer
            throw new RuntimeException("Did not find Photographer id - " + theId);
        }

        return thePhotographer;
    }

    @Override
    public void save(Photographer thePhotographer) {
        photographerRepository.save(thePhotographer);
    }

    @Override
    public void deleteById(int theId) {
        photographerRepository.deleteById(theId);
    }

}
