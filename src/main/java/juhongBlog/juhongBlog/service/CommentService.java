package juhongBlog.juhongBlog.service;

import juhongBlog.juhongBlog.domain.Comment;
import juhongBlog.juhongBlog.domain.Post;
import juhongBlog.juhongBlog.domain.User;
import juhongBlog.juhongBlog.jwt.JwtTokenProvider;
import juhongBlog.juhongBlog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final JwtTokenProvider jwtTokenProvider;

    // 댓글 추가
    public String  createComment(Comment comment, User user, Post post, String token) {
        if(!jwtTokenProvider.validateToken(token)) {
            return "토큰 유효하지 않음";
        }

        commentRepository.save(Comment.builder()
                .content(comment.getContent())
                .user(user)
                .post(post)
                .build()).getId();

        return "댓글이 추가되었습니다.";
    }


}
