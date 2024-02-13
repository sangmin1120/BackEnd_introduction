package com.example.Firstproject.api;

import com.example.Firstproject.dto.MemberForm;
import com.example.Firstproject.entity.Article;
import com.example.Firstproject.entity.Member;
import com.example.Firstproject.repository.MemberRepository;
import com.example.Firstproject.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MemberApiController {
    @Autowired
    MemberService memberService;

    // GET_ALL
    @GetMapping("/api/members")
    public List<Member> index(){
        return memberService.index();
    }
    // GET_find_by_id
    @GetMapping("/api/members/{id}")
    public  Member show(@PathVariable Long id){
        return memberService.show(id);
    }

    // POST
    @PostMapping("/api/members")
    public ResponseEntity<Member> create(@RequestBody MemberForm dto){
        Member created = memberService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // PATCH
    @PatchMapping("/api/members/{id}")
    public ResponseEntity<Member> update(@PathVariable Long id, @RequestBody MemberForm dto){
        Member updated = memberService.update(id,dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // DELETE
    @DeleteMapping("/api/members/{id}")
    public ResponseEntity<Member> delete(@PathVariable Long id){
        Member deleted = memberService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).body(deleted) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
