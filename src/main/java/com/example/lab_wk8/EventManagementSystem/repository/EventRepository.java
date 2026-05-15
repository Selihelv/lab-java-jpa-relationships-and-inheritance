package com.example.lab_wk8.EventManagementSystem.repository;

import com.example.lab_wk8.EventManagementSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
}
