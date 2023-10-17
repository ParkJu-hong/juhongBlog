package juhongBlog.juhongBlog.controller;


import juhongBlog.juhongBlog.domain.Comment;
import juhongBlog.juhongBlog.domain.Post;
import juhongBlog.juhongBlog.domain.User;
import juhongBlog.juhongBlog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    // 댓글 추가
    @PostMapping("comment/create")
    @ResponseBody
    public Long createComment(@RequestBody Comment comment, User user, Post post){
        return commentService.createComment(comment, user, post);
    }

}
