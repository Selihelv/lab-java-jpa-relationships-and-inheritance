package com.example.lab_wk8.PublicRelationsContactSystem.model;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Name {

    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;

}
