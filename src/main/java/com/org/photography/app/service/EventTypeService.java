package com.org.photography.app.service;

import com.org.photography.app.entity.EventType;

import java.util.List;

public interface EventTypeService {
    public List<EventType> findAll();

    public EventType findById(int theId);

    public void save(EventType theEventType);

    public void deleteById(int theId);
}
