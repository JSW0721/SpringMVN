package com.estsoft.springmvc.Service;

import com.estsoft.springmvc.DTO.CommentRequestDTO;
import com.estsoft.springmvc.DTO.article.Article;
import com.estsoft.springmvc.domain.Comment;
import com.estsoft.springmvc.repository.BlogRepository;
import com.estsoft.springmvc.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CommentService {
    BlogRepository blogRepository;
    CommentRepository commentRepository;

    public CommentService(BlogRepository blogRepository,CommentRepository commentRepository) {
        this.blogRepository = blogRepository;
        this.commentRepository = commentRepository;
    }
    public Comment saveComment(Long articleId, CommentRequestDTO requDTO) {
        Article article = blogRepository.findById(articleId).orElseThrow();//NosuchElementException
        return commentRepository.save(new Comment(requDTO.getBody(), article));
    }
    //GET /api/comments/{commentId}
    public Comment findComment(Long commentId){
        Optional<Comment> opcomm = commentRepository.findById(commentId);
        return opcomm.orElse(new Comment());
    }

    //UPDATE
    public Comment update(Long commentId, CommentRequestDTO requ){
        Comment comment = commentRepository.findById(commentId).orElseThrow();//없으면 예외 던지기
        //수정 시작
        comment.updateCommentBody(requ.getBody());
        return commentRepository.save(comment);
    }
    //Delete
    public void deleteComment(Long commentId){//테스트 코드 작성 생각하면 리턴 타입을 주기도 한다.
        commentRepository.deleteById(commentId);
    }
}
