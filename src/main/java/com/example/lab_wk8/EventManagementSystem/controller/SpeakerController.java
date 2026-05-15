package com.example.lab_wk8.EventManagementSystem.controller;

import com.example.lab_wk8.EventManagementSystem.model.Event;
import com.example.lab_wk8.EventManagementSystem.model.Speaker;
import com.example.lab_wk8.EventManagementSystem.service.SpeakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/speakers")
public class SpeakerController {

    private final SpeakerService speakerService;

    @GetMapping
    public List<Speaker> getAllSpeakers(){
        return speakerService.findAllSpeakers();
    }

    @GetMapping("/{id}")
    public Optional<Speaker> getById(@PathVariable Long id){
        return speakerService.findSpeakerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker saveSpeaker(@RequestBody Speaker speaker){
        return speakerService.save(speaker);
    }

    @PutMapping("/{id}")
    public Speaker updateSpeaker (@PathVariable Long id, @RequestBody Speaker speaker){
        return speakerService.updateSpeaker(id, speaker);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSpeaker(@PathVariable Long id){
        speakerService.deleteSpeaker(id);
    }
}
