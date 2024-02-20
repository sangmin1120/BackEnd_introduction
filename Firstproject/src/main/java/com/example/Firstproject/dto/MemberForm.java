package com.example.Firstproject.dto;

import com.example.Firstproject.entity.Article;
import com.example.Firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class MemberForm {
    private Long id;
    private String name;
    public String email;
    private String password;
    public Member toEntity() {
        return new Member(id,name,email,password);
    }
}
