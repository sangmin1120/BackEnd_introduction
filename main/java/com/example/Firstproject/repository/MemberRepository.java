package com.example.Firstproject.repository;

import com.example.Firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;
import com.example.Firstproject.entity.Member;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member,Long> {
    @Override
    ArrayList<Member> findAll(); // CrudRepositroy 는 생성 조회 수정 삭제 가능 JPA
}
