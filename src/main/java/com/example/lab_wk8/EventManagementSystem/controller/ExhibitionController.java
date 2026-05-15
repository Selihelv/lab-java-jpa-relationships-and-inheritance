package com.example.lab_wk8.EventManagementSystem.controller;

import com.example.lab_wk8.EventManagementSystem.model.Exhibition;
import com.example.lab_wk8.EventManagementSystem.model.Speaker;
import com.example.lab_wk8.EventManagementSystem.service.ExhibitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exhibitions")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    @GetMapping
    public List<Exhibition> getAllExhibitions(){
        return exhibitionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Exhibition> getById(@PathVariable Long id){
        return exhibitionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Exhibition saveExhibition(@RequestBody Exhibition exhibition){
        return exhibitionService.save(exhibition);
    }

    @PutMapping("/{id}")
    public Exhibition updateExhibition (@PathVariable Long id, @RequestBody Exhibition exhibition){
        return exhibitionService.update(id, exhibition);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExhibition(@PathVariable Long id){
        exhibitionService.delete(id);
    }

}
