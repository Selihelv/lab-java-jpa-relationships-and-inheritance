package com.example.lab_wk8.PublicRelationsContactSystem.repository;

import com.example.lab_wk8.PublicRelationsContactSystem.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
