package com.rocketseat.events.service;

import com.rocketseat.events.model.Event;
import com.rocketseat.events.repository.EventRepository;

public class EventService {

    private EventRepository eventRepository;

    public Event addNewEvent(Event event){
         event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ","-"));
         return eventRepository.save(event);
    };
}
