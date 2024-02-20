package com.example.Firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity // 엔티티 선언
@Getter
public class Article {
    @Id // 엔티티의 대푯값 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 기능 추가(숫자가 자동으로 매겨짐)
    private Long id;
    @ManyToOne // member 엔티티와 Article 엔티티를 다대일 관계로 설정
    @JoinColumn(name="user_id") // 외래키 생성,Member 엔티티의 기본키(id)와 매핑
    private Member member; // 해당 댓글의 부모 게시글
    @Column // title 필드 선언, DB 테이블의 title 열과 연결됨
    private String title;
    @Column // content 필드 선언, DB 테이블의 content 열과 연결됨
    private String content;

    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }
}
