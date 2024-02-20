package com.example.Firstproject.dto;

import com.example.Firstproject.entity.Article;
import com.example.Firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private Member member;
    private  String title;
    private  String content;

    public Article toEntity(){
        return new Article(id,member,title,content);
    }
}
