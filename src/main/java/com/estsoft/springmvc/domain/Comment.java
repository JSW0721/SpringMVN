package com.estsoft.springmvc.domain;

import com.estsoft.springmvc.DTO.article.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @Column
    private String body;

    @Column
    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    public Comment(){

    }
    public Comment(String body, Article article){
        this.body = body;
        this.article = article;
    }

    public void updateCommentBody(String body) {
        this.body = body;
    }
}
