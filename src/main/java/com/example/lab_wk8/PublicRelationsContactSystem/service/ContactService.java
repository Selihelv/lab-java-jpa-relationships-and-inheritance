package com.example.lab_wk8.PublicRelationsContactSystem.service;

import com.example.lab_wk8.PublicRelationsContactSystem.model.Contact;
import com.example.lab_wk8.PublicRelationsContactSystem.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;


    public List<Contact> getAll(){
        return contactRepository.findAll();
    }

    public Optional<Contact> getById(Long id){
        return contactRepository.findById(id);
    }

    public Contact save(Contact contact){
        return contactRepository.save(contact);
    }

    public Contact update(Long id, Contact contact){
        var contactToUpdate = getById(id).orElseThrow(
                () -> new RuntimeException("Contact with id: " + id + " not found!"));
       contactToUpdate.setCompany(contact.getCompany());
        contactToUpdate.setTitle(contact.getTitle());
        contactToUpdate.setName(contact.getName());

        return contactRepository.save(contactToUpdate);
    }

    public void delete(Long id){
        contactRepository.deleteById(id);
    }

}
