package com.estsoft.springmvc.DTO;

import com.estsoft.springmvc.DTO.article.Article;
import com.estsoft.springmvc.DTO.article.ArticleResponse;
import com.estsoft.springmvc.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.format.DateTimeFormatter;

import static com.estsoft.springmvc.util.DateFormatUtil.formatter;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDTO {
    private Long commentid;
    private Long articleid;
    private String body;
    private String createdAt;  //yyyy-mm-dd hh:mm:ss
    private ArticleResponse article;

    public CommentResponseDTO(Comment comment) {
        Article articleFormComment = comment.getArticle();

        commentid = comment.getId();
        articleid = articleFormComment.getId();
        body = comment.getBody();
        createdAt = comment.getCreateAt().format(formatter);
        article = new ArticleResponse(articleFormComment);
    }
}
