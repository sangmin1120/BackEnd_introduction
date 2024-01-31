package com.example.Firstproject.dto;

import com.example.Firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberForm {
    private Long id;
    private String name;
    private String email;
    private String password;
    public Member toEntity() {
        return new Member(id,name,email,password);
    }
}
