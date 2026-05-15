package com.example.lab_wk8.NurseAssociationDivisionManagement.service;

import com.example.lab_wk8.NurseAssociationDivisionManagement.model.Member;
import com.example.lab_wk8.NurseAssociationDivisionManagement.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;



    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    public Optional<Member> getById(Long id){
        var association = memberRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Member with id: " + id + " not found.")
        );
        return memberRepository.findById(id);
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public Member update(Long id, Member member){
        var memberToUpdate = getById(id).orElseThrow(
                () -> new RuntimeException("Association with id: " + id + " not found."));
        memberToUpdate.setName(member.getName());
        memberToUpdate.setDivision(member.getDivision());
        memberToUpdate.setStatus(member.getStatus());
        memberToUpdate.setRenewalDate(member.getRenewalDate());

        return memberRepository.save(memberToUpdate);
    }

    public void delete(Long id){
        memberRepository.deleteById(id);
    }


}
