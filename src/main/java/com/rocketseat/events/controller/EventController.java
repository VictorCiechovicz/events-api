package com.rocketseat.events.controller;

import com.rocketseat.events.model.Event;
import com.rocketseat.events.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events")
    public Event addNewEvent(@RequestBody Event newEvent){
        return eventService.addNewEvent(newEvent);
    };

    @GetMapping("/events")
    public List<Event> findAll(){
        return eventService.findAll();
    }

@GetMapping("/events/{prettyName}")
    public ResponseEntity<Event> getByPrettyName(@PathVariable String prettyName){
      return eventService.findByPrettyName(prettyName);

    };
}
