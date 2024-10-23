package com.estsoft.springmvc.DTO.article;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "블로그 조회 결과")
public class ArticleResponse {
    @Schema(description = "블로그 ID", type = "Long")
    private Long id;
    @Schema(description = "블로그 제목", type = "String")
    private String title;
    @Schema(description = "블로그 내용", type = "String")
    private String content;
    @Schema(description = "생성 시간", type = "LocalDateTime")
    private LocalDateTime createdAt;


    public ArticleResponse(Article article) {
        id = article.getId();
        title = article.getTitle();
        content = article.getContent();
        createdAt = article.getCreatedAt();
    }
}
