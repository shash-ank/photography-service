package com.org.photography.app.rest;

import com.org.photography.app.entity.EventType;
import com.org.photography.app.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class EventTypeRestController {
    private EventTypeService eventTypeService;

    @Autowired
    public EventTypeRestController(EventTypeService theEventTypeService) {
        eventTypeService = theEventTypeService;
    }

    @GetMapping("/eventtypes")
    public List<EventType> findAll() {
        return eventTypeService.findAll();
    }

    @GetMapping("/eventtypes/{id}")
    public EventType getEventType(@PathVariable int id) {
        EventType eventType = eventTypeService.findById(id);
        if (eventType == null) {
            throw new RuntimeException("EventType not found -" + id);

        }
        return eventType;
    }

    @PostMapping("/eventtypes")
    public EventType addEventType(@RequestParam String eventName, @RequestParam String duration) {
        String timePattern="([01]?[0-9]|2[0-3]):([0-5][0-9])";
        Pattern pattern = Pattern.compile(timePattern);
        Matcher hourAndMinuteMatcher = pattern.matcher(duration);
        long hours=0;
        long minutes=0;
        long convertedDuration=0;
        if (hourAndMinuteMatcher.matches()){
            hours=Long.parseLong(hourAndMinuteMatcher.group(1));
            minutes=Long.parseLong(hourAndMinuteMatcher.group(2));
            convertedDuration=hours*3600000+minutes*60000;
        }
        else
        {
            throw new InputMismatchException("Required duration to be in format HH:MM but found: "+duration);
        }
        EventType eventType = new EventType(eventName,convertedDuration);
        eventType.setEventId(0);
        eventTypeService.save(eventType);
        return eventType;
    }

    @PutMapping("/eventtypes")
    public EventType updateEventType(@RequestBody EventType eventType) {
        eventTypeService.save(eventType);
        return eventType;
    }

    @DeleteMapping("/eventtypes/{eventTypeId}")
    public String deleteEventType(@PathVariable int eventTypeId) {
        EventType tempEventType = eventTypeService.findById(eventTypeId);
        if (tempEventType == null) {
            throw new RuntimeException("EventType id not found "+eventTypeId);
        }
        eventTypeService.deleteById(eventTypeId);
        return "Deleted EventType with id - "+eventTypeId;
    }
}
