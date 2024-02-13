package com.example.Firstproject.repository;

import com.example.Firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article,Long> {
    @Override
    ArrayList<Article> findAll(); // CrudRepositroy 는 생성 조회 수정 삭제 가능 JPA

}
