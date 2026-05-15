package com.example.lab_wk8.EventManagementSystem.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Speaker {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer presentationDuration;

    @ManyToMany(mappedBy = "speakers", fetch = FetchType.EAGER)
    private List<Conference> conferences = new ArrayList<>();
}
