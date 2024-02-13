package com.example.Firstproject.service;

import com.example.Firstproject.dto.MemberForm;
import com.example.Firstproject.entity.Member;
import com.example.Firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> index() {
        return memberRepository.findAll();
    }

    public Member show(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member create(MemberForm dto) {
        Member created = dto.toEntity();
        if (created.getId() != null){
            return null;
        }
        return memberRepository.save(created);
    }

    public Member delete(Long id) {
        Member target = memberRepository.findById(id).orElse(null);
        if (target == null){
            return null;
        }
        memberRepository.delete(target);
        return target;
    }

    public Member update(Long id, MemberForm dto) {
        Member member = dto.toEntity();
        log.info("ID : {} , member : {}",id,member.toString());
        Member target = memberRepository.findById(id).orElse(null);
        if (target == null){
            // 400 error
            log.info("잘못된 요청! id: {},article: {}", id, member.toString());
            return null;
        }
        // 수정
        target.patch(member);
        // 갱신
        Member updated = memberRepository.save(target);
        return updated;
    }
}
