package com.org.photography.app.service;

import com.org.photography.app.entity.EventType;
import com.org.photography.app.repository.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EventTypeServiceImpl implements EventTypeService {
    private EventTypeRepository eventTypeRepository;

    @Autowired
    public EventTypeServiceImpl(EventTypeRepository theEventTypeRepository) {
        eventTypeRepository = theEventTypeRepository;
    }

    @Override
    public List<EventType> findAll() {
        return eventTypeRepository.findAll();
    }

    @Override
    public EventType findById(int theId) {
        Optional<EventType> result = eventTypeRepository.findById(theId);

        EventType theEventType = null;

        if (result.isPresent()) {
            theEventType = result.get();
        }
        else {
            // we didn't find the EventType
            throw new RuntimeException("Did not find EventType id - " + theId);
        }

        return theEventType;
    }

    @Override
    public void save(EventType theEventType) {
        eventTypeRepository.save(theEventType);
    }

    @Override
    public void deleteById(int theId) {
        eventTypeRepository.deleteById(theId);
    }

}
