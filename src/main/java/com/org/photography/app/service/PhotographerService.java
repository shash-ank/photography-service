package com.org.photography.app.service;

import com.org.photography.app.entity.Photographer;

import java.util.List;

public interface PhotographerService {
    public List<Photographer> findAll();

    public Photographer findById(int theId);

    public void save(Photographer thePhotographer);

    public void deleteById(int theId);
}
