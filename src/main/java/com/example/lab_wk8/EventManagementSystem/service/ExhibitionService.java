package com.example.lab_wk8.EventManagementSystem.service;

import com.example.lab_wk8.EventManagementSystem.model.Exhibition;
import com.example.lab_wk8.EventManagementSystem.repository.ExhibitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    public List<Exhibition> findAll(){
        return exhibitionRepository.findAll();
    }

    public Optional<Exhibition> findById(Long id){
        return exhibitionRepository.findById(id);
    }

    public Exhibition save (Exhibition exhibition){
        return exhibitionRepository.save(exhibition);
    }

    public Exhibition update(Long id, Exhibition exhibition){
        var exhibitionToUpdate = exhibitionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Exhibition with id " + id + " not found")
        );
        exhibitionToUpdate.setTitle(exhibition.getTitle());
        exhibitionToUpdate.setDate(exhibition.getDate());
        exhibitionToUpdate.setDuration(exhibition.getDuration());
        exhibitionToUpdate.setLocation(exhibition.getLocation());
        exhibitionToUpdate.setGuests(exhibition.getGuests());

        return exhibitionRepository.save(exhibitionToUpdate);
    }

    public void delete(Long id){
        exhibitionRepository.deleteById(id);
    }
}
