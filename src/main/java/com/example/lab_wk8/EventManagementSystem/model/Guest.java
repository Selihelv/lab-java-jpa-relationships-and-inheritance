package com.example.lab_wk8.EventManagementSystem.model;

import com.example.lab_wk8.EventManagementSystem.enums.GuestStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GuestStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
