package com.org.photography.app.repository;

import com.org.photography.app.entity.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotographerRepository extends JpaRepository<Photographer, Integer> {

}
