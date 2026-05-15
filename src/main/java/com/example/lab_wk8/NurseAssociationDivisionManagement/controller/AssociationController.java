package com.example.lab_wk8.NurseAssociationDivisionManagement.controller;

import com.example.lab_wk8.NurseAssociationDivisionManagement.model.Association;
import com.example.lab_wk8.NurseAssociationDivisionManagement.service.AssociationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/associations")
public class AssociationController {

    private final AssociationService associationService;


    @GetMapping
    public List<Association> getAllAssociations(){
        return associationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Association> getById(@PathVariable Long id){
        return associationService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Association saveAssociation(@RequestBody Association association){
        return associationService.save(association);
    }

    @PutMapping("/{id}")
    public Association updateAssociation (@PathVariable Long id, @RequestBody Association association ){
        return associationService.update(id, association);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAssociation(@PathVariable Long id){
        associationService.delete(id);
    }

}
