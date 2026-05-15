package com.example.lab_wk8.EventManagementSystem.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Conference extends Event {


    @ManyToMany
    @JoinTable(
            name = "conference_speaker",
            joinColumns = @JoinColumn( name= "conference_id"),
            inverseJoinColumns = @JoinColumn( name = "speaker_id")
    )
    private List<Speaker> speakers = new ArrayList<>();
}
