package com.example.lab_wk8.EventManagementSystem.service;

import com.example.lab_wk8.EventManagementSystem.model.Event;
import com.example.lab_wk8.EventManagementSystem.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public Optional<Event> findById(Long id){
        return eventRepository.findById(id);
    }

    public Event save(Event event){
        return eventRepository.save(event);
    }

    public Event update(Long id, Event event){
       var eventToUpdate = eventRepository.findById(id).orElseThrow(
               ()-> new RuntimeException("Event with id: " + id + " not found.")
       );
       eventToUpdate.setTitle(event.getTitle());
        eventToUpdate.setDate(event.getDate());
        eventToUpdate.setDuration(event.getDuration());
        eventToUpdate.setLocation(event.getLocation());
        eventToUpdate.setGuests(event.getGuests());

        return eventRepository.save(eventToUpdate);
    }

    public void delete(Long id){
        eventRepository.deleteById(id);
    }
}
