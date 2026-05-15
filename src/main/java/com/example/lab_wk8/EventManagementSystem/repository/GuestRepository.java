package com.example.lab_wk8.EventManagementSystem.repository;

import com.example.lab_wk8.EventManagementSystem.enums.GuestStatusEnum;
import com.example.lab_wk8.EventManagementSystem.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

    List<Guest> findGuestByStatus(GuestStatusEnum status);

}
