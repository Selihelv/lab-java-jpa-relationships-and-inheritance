package com.example.lab_wk8.NurseAssociationDivisionManagement.service;

import com.example.lab_wk8.NurseAssociationDivisionManagement.model.Association;
import com.example.lab_wk8.NurseAssociationDivisionManagement.repository.AssociationRepository;
import com.example.lab_wk8.NurseAssociationDivisionManagement.repository.DivisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssociationService {

    private final AssociationRepository associationRepository;

    public List<Association> getAll(){
        return associationRepository.findAll();
    }

    public Optional<Association> getById(Long id){
        var association = associationRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Association with id: " + id + " not found.")
        );
        return associationRepository.findById(id);
    }

    public Association save(Association association){
        return associationRepository.save(association);
    }

    public Association update(Long id, Association association){
        var associationToUpdate = getById(id).orElseThrow(
                () -> new RuntimeException("Association with id: " + id + " not found."));
        associationToUpdate.setName(association.getName());
        associationToUpdate.setListOfDivisions(association.getListOfDivisions());

        return associationRepository.save(associationToUpdate);
    }

    public void delete(Long id){
        associationRepository.deleteById(id);
    }
}
