package com.example.Firstproject.entity;

import com.example.Firstproject.DTO.MemberForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.WebProperties;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동으로 id생성하고 부여
    private Long id;
    @Column
    private String email;
    @Column
    private String password;

    public void patch(MemberForm dto) {
        if (this.getId() != dto.getId()){
            throw new IllegalArgumentException("댓글 수정 실패..!");
        }
        if (this.getEmail() != dto.getEmail()){ this.email = dto.getEmail();}
        if (this.getPassword() != dto.getPassword()) {  this.password = dto.getPassword();}
    }
}
