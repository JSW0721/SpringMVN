package com.estsoft.springmvc.domain;

import com.estsoft.springmvc.DTO.article.Article;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
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

    @Builder
    public Comment(String body, Article article){
        this.body = body;
        this.article = article;
    }
    public void updateCommentBody(String body) {
        this.body = body;
    }
}
