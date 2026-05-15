package com.example.lab_wk8.PublicRelationsContactSystem.controller;

import com.example.lab_wk8.PublicRelationsContactSystem.model.Contact;
import com.example.lab_wk8.PublicRelationsContactSystem.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;


    @GetMapping
    public List<Contact> getAllContacts(){
        return contactService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Contact> getById(@PathVariable Long id){
        return contactService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact saveContact(@RequestBody Contact contact){
        return contactService.save(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact (@PathVariable Long id, @RequestBody Contact contact){
        return contactService.update(id, contact);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable Long id){
        contactService.delete(id);
    }

}
