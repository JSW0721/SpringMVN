package com.estsoft.springmvc.DTO;

import com.estsoft.springmvc.DTO.article.Article;
import com.estsoft.springmvc.DTO.article.ArticleResponse;
import com.estsoft.springmvc.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDTO {
    private Long commentid;
    private Long articleid;
    private String body;
    private LocalDateTime createdAt;
    private ArticleResponse article;

    public CommentResponseDTO(Comment comment) {
        commentid = comment.getId();
        body = comment.getBody();
        createdAt = comment.getCreateAt();
        article = new ArticleResponse(comment.getArticle());
    }
}
