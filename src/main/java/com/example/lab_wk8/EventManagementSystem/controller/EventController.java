package com.example.lab_wk8.EventManagementSystem.controller;

import com.example.lab_wk8.EventManagementSystem.model.Event;
import com.example.lab_wk8.EventManagementSystem.model.Guest;
import com.example.lab_wk8.EventManagementSystem.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Event> getById(@PathVariable Long id){
        return eventService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event saveEvent(@RequestBody Event event){
        return eventService.save(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent (@PathVariable Long id, @RequestBody Event event){
        return eventService.update(id, event);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEvent(@PathVariable Long id){
        eventService.delete(id);
    }
}
