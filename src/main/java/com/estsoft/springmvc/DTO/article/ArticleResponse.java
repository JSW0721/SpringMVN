package com.estsoft.springmvc.DTO.article;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "블로그 조회 결과")
public class ArticleResponse {
    @Schema(description = "블로그 ID", type = "Long")
    private Long articleId;
    @Schema(description = "블로그 제목", type = "String")
    private String title;
    @Schema(description = "블로그 내용", type = "String")
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedAt;

    @Builder
    public ArticleResponse(Article article) {
        articleId = article.getId();
        title = article.getTitle();
        content = article.getContent();
        createdAt = article.getCreatedAt();
        updatedAt = article.getUpdatedAt();
    }
}
