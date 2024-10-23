package com.estsoft.springmvc.Controller;

import com.estsoft.springmvc.DTO.CommentRequestDTO;
import com.estsoft.springmvc.DTO.CommentResponseDTO;
import com.estsoft.springmvc.Service.CommentService;
import com.estsoft.springmvc.domain.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("aoi/articles/{articleId}/comments")
    public ResponseEntity<CommentResponseDTO> saveCommentByArtilceId(@PathVariable Long articleId, @RequestBody CommentRequestDTO requDTO){
        Comment comment = commentService.saveComment(articleId, requDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CommentResponseDTO(comment));
    }

    @GetMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentResponseDTO> getCommentsByArticleId(@PathVariable("commentId")Long id){
        Comment comment = commentService.findComment(id);
        return ResponseEntity.ok(new CommentResponseDTO(comment));
    }
    @PutMapping("/api/comments/{commentId}")
    public ResponseEntity<CommentResponseDTO> updateCommentById(@PathVariable Long commentId, @RequestBody CommentRequestDTO requDTO){
        Comment updated = commentService.update(commentId, requDTO);
        return ResponseEntity.ok(new CommentResponseDTO(updated));
    }
    @DeleteMapping("/api/comments/{commentID}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Long commentID){
        commentService.deleteComment(commentID);
        return ResponseEntity.ok().build();
    }
}
