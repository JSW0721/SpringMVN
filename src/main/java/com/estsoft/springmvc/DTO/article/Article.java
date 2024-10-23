package com.estsoft.springmvc.DTO.article;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;

    //Article 생성자
    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public ArticleResponse toArticleResponse() {
        return new ArticleResponse(id, title, content, createdAt);
    }
    public void update(String title, String content) {
        //if(title.isBlank()){this.title = title};
        this.title = title;
        this.content = content;
    }
}
