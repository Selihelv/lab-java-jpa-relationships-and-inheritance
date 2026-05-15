package com.example.lab_wk8.NurseAssociationDivisionManagement.controller;

import com.example.lab_wk8.NurseAssociationDivisionManagement.model.Member;
import com.example.lab_wk8.NurseAssociationDivisionManagement.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;



    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Member> getById(@PathVariable Long id){
        return memberService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member saveMember(@RequestBody Member member){
        return memberService.save(member);
    }

    @PutMapping("/{id}")
    public Member updateMember (@PathVariable Long id, @RequestBody Member member){
        return memberService.update(id, member);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable Long id){
        memberService.delete(id);
    }


}
