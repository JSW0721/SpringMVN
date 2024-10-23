package com.estsoft.springmvc.Controller;

import com.estsoft.springmvc.DTO.article.AddArticleRequest;
import com.estsoft.springmvc.DTO.article.Article;
import com.estsoft.springmvc.DTO.article.ArticleResponse;
import com.estsoft.springmvc.DTO.article.UpdateArticleRequest;
import com.estsoft.springmvc.Service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "블로그 CRUD")
@Slf4j //annotation for logging.
@RestController
@RequestMapping("/api")
public class BlogController {
    private final BlogService service;

    public BlogController(BlogService service){
        this.service = service;
    }
    //RequestMapping (특정 URL  GET /articles)
    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping("/articles")
    public ResponseEntity<ArticleResponse> writeArticle(@RequestBody AddArticleRequest request){

        Article article = service.saveArticle(request);

        System.out.println(request.getTitle());
        System.out.println(request.getContent());

        //trace,debug,ingo,warn,error
        log.info("{},{}", request.getTitle(), request.getContent());
        log.trace("{},{}", request.getTitle(), request.getContent());
        log.debug("{},{}", request.getTitle(), request.getContent());

        return ResponseEntity.status(HttpStatus.CREATED).body(article.toArticleResponse());
    }
    //Request Mapping blog리스트 가져오기
    @Operation(summary = "블로그 전체 보기")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "요청성공",content= @Content(mediaType = "application/json")),})
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> findAll(){
        List<ArticleResponse> articleList = service.findAll().stream()
                .map(Article::toArticleResponse)
                .toList();
        return ResponseEntity.ok(articleList);
    }
    //Request Mapping blog 단건 조회
    @Parameter(name = "id",description = "블로그 글 ID", example = "45")
    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> findById(@PathVariable Long id){
        Article article = service.findBy(id); // 실패 케이스 : Exception(5XX 서버 오류) -> 4xx Status Code

        //Article -> ArticleResponse
        return ResponseEntity.ok(article.toArticleResponse());
    }
    //@RequestMapping(method = RequestMethod.DELETE, value = "/article/{id}")
    @Parameter(name = "id",description = "블로그 글 ID", example = "1")
    @DeleteMapping ("/articles/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IllegalArgumentException.class) //500번대 오류를 400번대 오류로 전환하여 표시.
    public ResponseEntity<String> handleillegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable Long id, @RequestBody UpdateArticleRequest request){
        Article UpdatedArticle = service.update(id,request);
        return ResponseEntity.ok(UpdatedArticle.toArticleResponse());
    }
}
