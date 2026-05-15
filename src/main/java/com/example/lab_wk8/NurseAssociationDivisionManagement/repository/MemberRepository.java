package com.example.lab_wk8.NurseAssociationDivisionManagement.repository;

import com.example.lab_wk8.NurseAssociationDivisionManagement.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
