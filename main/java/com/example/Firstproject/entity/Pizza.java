package com.example.Firstproject.entity;

import com.example.Firstproject.dto.CommentDto;
import com.example.Firstproject.dto.PizzaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Pizza {
    @Id // 엔티티의 대푯값 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 기능 추가(숫자가 자동으로 매겨짐)
    private Long id;
    @Column // title 필드 선언, DB 테이블의 title 열과 연결됨
    private String name;
    @Column // content 필드 선언, DB 테이블의 content 열과 연결됨
    private String price;

    public void patch(Pizza pizza) {
        if (this.name != pizza.getName())
            this.name = pizza.getName();
        if (this.price != pizza.getPrice())
            this.price = pizza.getPrice();
    }
}
