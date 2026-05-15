package com.example.lab_wk8.EventManagementSystem.service;

import com.example.lab_wk8.EventManagementSystem.model.Speaker;
import com.example.lab_wk8.EventManagementSystem.repository.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SpeakerService {

    private final SpeakerRepository speakerRepository;


    public List<Speaker> findAllSpeakers(){
        return speakerRepository.findAll();
    }

    public Optional<Speaker> findSpeakerById(Long id){
        return speakerRepository.findById(id);
    }

    public Speaker save(Speaker speaker){
        return speakerRepository.save(speaker);
    }

    public Speaker updateSpeaker(Long id, Speaker speaker){
       var speakerToUpdate = speakerRepository.findById(id).orElseThrow(
               () -> new RuntimeException("Speaker with id " + id + " not found")
       );
       speakerToUpdate.setName(speaker.getName());
       speakerToUpdate.setPresentationDuration(speaker.getPresentationDuration());
       speakerToUpdate.setConferences(speaker.getConferences());

        return speakerRepository.save(speakerToUpdate);
    }

    public void deleteSpeaker(Long id){
        speakerRepository.deleteById(id);
    }
}
