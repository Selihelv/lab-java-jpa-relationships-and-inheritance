package com.example.lab_wk8.EventManagementSystem.controller;

import com.example.lab_wk8.EventManagementSystem.model.Guest;
import com.example.lab_wk8.EventManagementSystem.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guests")
public class GuestController {

    private final GuestService guestService;


    @GetMapping
    public List<Guest> getAllGuests(){
        return guestService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Guest> getById(@PathVariable Long id){
        return guestService.findGuestById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guest saveGuest(@RequestBody Guest guest){
        return guestService.save(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest (@PathVariable Long id, @RequestBody Guest guest){
        return guestService.update(id, guest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuest(@PathVariable Long id){
        guestService.delete(id);
    }


}
