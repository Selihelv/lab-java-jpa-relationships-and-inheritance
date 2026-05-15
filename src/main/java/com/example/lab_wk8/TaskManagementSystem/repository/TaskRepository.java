package com.example.lab_wk8.TaskManagementSystem.repository;

import com.example.lab_wk8.TaskManagementSystem.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {



}
