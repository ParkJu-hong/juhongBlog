package juhongBlog.juhongBlog.service;

import juhongBlog.juhongBlog.domain.Comment;
import juhongBlog.juhongBlog.domain.Post;
import juhongBlog.juhongBlog.domain.User;
import juhongBlog.juhongBlog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    // 댓글 추가
    public Long createComment(Comment comment, User user, Post post) {
        return commentRepository.save(Comment.builder()
                .content(comment.getContent())
                .user(user)
                .post(post)
                .build()).getId();
    }


}
