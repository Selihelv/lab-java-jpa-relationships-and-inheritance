package com.example.lab_wk8.NurseAssociationDivisionManagement.repository;

import com.example.lab_wk8.NurseAssociationDivisionManagement.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long> {

    Optional<Division> findDivisionsByDistrict(String district);
}
