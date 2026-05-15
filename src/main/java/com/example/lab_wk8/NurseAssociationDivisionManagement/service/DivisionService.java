package com.example.lab_wk8.NurseAssociationDivisionManagement.service;

import com.example.lab_wk8.NurseAssociationDivisionManagement.model.Division;
import com.example.lab_wk8.NurseAssociationDivisionManagement.repository.DivisionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DivisionService {

    private final DivisionRepository divisionRepository;


    public List<Division> getAll(){
        return divisionRepository.findAll();
    }

    public Optional<Division> getById(Long id){
        var division = divisionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Division with id: " + id + " not found.")
        );
        return divisionRepository.findById(id);
    }

    public Division save(Division division){
        return divisionRepository.save(division);
    }

    public Division update(Long id, Division division){
        var divisionToUpdate = getById(id).orElseThrow(
                () -> new RuntimeException("Association with id: " + id + " not found."));
        divisionToUpdate.setAssociation(division.getAssociation());
        divisionToUpdate.setName(division.getName());
        divisionToUpdate.setDistrict(division.getDistrict());
        divisionToUpdate.setMembers(division.getMembers());
        divisionToUpdate.setPresident(division.getPresident());

        return divisionRepository.save(divisionToUpdate);
    }

    public void delete(Long id){
        divisionRepository.deleteById(id);
    }

    public Optional<Division> findDivisionsByDistrict(String district){
        return divisionRepository.findDivisionsByDistrict(district);
    }

}
