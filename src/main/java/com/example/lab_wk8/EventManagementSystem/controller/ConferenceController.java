package com.example.lab_wk8.EventManagementSystem.controller;

import com.example.lab_wk8.EventManagementSystem.model.Conference;
import com.example.lab_wk8.EventManagementSystem.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/conferences")
public class ConferenceController {

    private final ConferenceService conferenceService;


     @GetMapping
    public List<Conference> getAllConferences(){
        return conferenceService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Conference> getById(@PathVariable Long id){
        return conferenceService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conference saveConference(@RequestBody Conference conference){
        return conferenceService.save(conference);
    }

    @PutMapping("/{id}")
    public Conference updateConference (@PathVariable Long id, @RequestBody Conference conference){
        return conferenceService.update(id, conference);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConference(@PathVariable Long id){
        conferenceService.delete(id);
    }
}
