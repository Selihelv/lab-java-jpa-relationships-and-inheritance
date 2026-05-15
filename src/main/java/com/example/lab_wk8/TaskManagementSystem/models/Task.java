package com.example.lab_wk8.TaskManagementSystem.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String title;
   private LocalDate dueDate;

   @Column(name= "is_completed")
   private Boolean isCompleted;
}
