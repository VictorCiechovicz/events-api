package com.rocketseat.events.service;

import com.rocketseat.events.model.Event;
import com.rocketseat.events.repository.EventRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addNewEvent(Event event){
         event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ","-"));
         return eventRepository.save(event);
    };

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public ResponseEntity<Event> findByPrettyName(String prettyName){
        Event event = eventRepository.findByPrettyName(prettyName);
        if (event == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(event);
    }
}

