package com.example.Firstproject.repository;

import com.example.Firstproject.entity.Article;
import com.example.Firstproject.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.Firstproject.entity.Member;

import java.util.ArrayList;
import java.util.List;

public interface MemberRepository extends CrudRepository<Member,Long> {
    @Override
    ArrayList<Member> findAll(); // CrudRepositroy 는 생성 조회 수정 삭제 가능 JPA

    @Query(value = "select * from member where email = :get_email",
            nativeQuery = true)
    Member findbyMemberemail(String get_email);
}
