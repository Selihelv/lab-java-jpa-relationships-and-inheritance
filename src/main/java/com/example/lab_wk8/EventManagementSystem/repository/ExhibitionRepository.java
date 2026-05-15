package com.example.lab_wk8.EventManagementSystem.repository;

import com.example.lab_wk8.EventManagementSystem.model.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition,Long> {
}
