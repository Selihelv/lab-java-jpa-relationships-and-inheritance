package com.example.lab_wk8.EventManagementSystem.service;

import com.example.lab_wk8.EventManagementSystem.model.Conference;
import com.example.lab_wk8.EventManagementSystem.repository.ConferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;




     public List<Conference> findAll(){
        return conferenceRepository.findAll();
    }

    public Optional<Conference> findById(Long id){
        return conferenceRepository.findById(id);
    }

    public Conference save(Conference conference){
        return conferenceRepository.save(conference);
    }

    public Conference update(Long id, Conference conference){
       var conferenceToUpdate = conferenceRepository.findById(id).orElseThrow(
               ()-> new RuntimeException("Conference with id: " + id + " not found.")
       );
       conferenceToUpdate.setTitle(conference.getTitle());
        conferenceToUpdate.setDate(conference.getDate());
        conferenceToUpdate.setDuration(conference.getDuration());
        conferenceToUpdate.setLocation(conference.getLocation());
        conferenceToUpdate.setGuests(conference.getGuests());
        conferenceToUpdate.setSpeakers(conference.getSpeakers());

        return conferenceRepository.save(conferenceToUpdate);
    }

    public void delete(Long id){
        conferenceRepository.deleteById(id);
    }

}
