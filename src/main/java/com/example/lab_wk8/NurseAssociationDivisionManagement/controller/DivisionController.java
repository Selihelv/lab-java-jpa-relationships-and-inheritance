package com.example.lab_wk8.NurseAssociationDivisionManagement.controller;

import com.example.lab_wk8.NurseAssociationDivisionManagement.model.Division;
import com.example.lab_wk8.NurseAssociationDivisionManagement.service.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/divisions")
public class DivisionController {

    private final DivisionService divisionService;


     @GetMapping
    public List<Division> getAllDivisions(){
        return divisionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Division> getById(@PathVariable Long id){
        return divisionService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Division saveDivision(@RequestBody Division division){
        return divisionService.save(division);
    }

    @PutMapping("/{id}")
    public Division updateDivision (@PathVariable Long id, @RequestBody Division division){
        return divisionService.update(id, division);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDivision(@PathVariable Long id){
        divisionService.delete(id);
    }

    @GetMapping("/district/{district}")
    public Optional<Division> getByDistrict(@PathVariable String district){
         return divisionService.findDivisionsByDistrict(district);
    }
}
