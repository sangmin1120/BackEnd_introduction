package com.example.Firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Member {
    @Id // 엔티티의 대푯값 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 기능 추가(숫자가 자동으로 매겨짐)
    private Long id;
    @Column
    private String name;
    @Column // email 필드 선언, DB 테이블의 title 열과 연결됨
    private String email;
    @Column // password 필드 선언, DB 테이블의 content 열과 연결됨
    private String password;

    public void patch(Member member) {
        if (member.getName() != name)
            this.name = member.getName();
        if (member.getEmail() != email)
            this.email = member.getEmail();
        if (member.getPassword() != password)
            this.password = member.getPassword();
    }
}
