package com.estsoft.springmvc.DTO;

import com.estsoft.springmvc.DTO.article.Article;
import com.estsoft.springmvc.DTO.article.ArticleResponse;
import com.estsoft.springmvc.domain.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDTO {
    private Long commentId;
    private Long articleId;
    private String body;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss")
    private LocalDateTime createdAt;  //yyyy-mm-dd hh:mm:ss
    private ArticleResponse article;

    public CommentResponseDTO(Comment comment) {
        Article articleFormComment = comment.getArticle();

        commentId = comment.getId();
        articleId = articleFormComment.getId();
        body = comment.getBody();
        createdAt = comment.getCreateAt();
        article = new ArticleResponse(articleFormComment);
    }
}
