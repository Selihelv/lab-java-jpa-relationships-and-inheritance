package com.example.lab_wk8.TaskManagementSystem.models;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BillableTask extends Task{

    private Double hourlyRate;

}
