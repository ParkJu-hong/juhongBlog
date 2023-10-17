package juhongBlog.juhongBlog.controller;


import juhongBlog.juhongBlog.domain.*;
import juhongBlog.juhongBlog.repository.PostRepository;
import juhongBlog.juhongBlog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;

    // 게시물 게시
    @PostMapping("post/create")
    @ResponseBody
    public String createPost(@RequestBody Post post, Long userId, Long categoryId, Long tagId, List<Image> images) {
        return postService.createPost(post, userId, categoryId, tagId, images);
    }

    // 게시물 수정
    @PostMapping("post/update")
    @ResponseBody
    public String updatePost(Long postId, Post post, Long userId, Long categoryId, Long tagId, List<Image> images) {
        return postService.updatePost(postId, post, userId, categoryId, tagId, images);
    }

    // 게시물 삭제
    @GetMapping("post/delete/{id}")
    @ResponseBody
    public String deletePost(@PathVariable("id") Long id) {
        return postService.deletePost(id);
    }

    // 게시물 검색 (부분조회)
    @PostMapping("post/findByTitle")
    @ResponseBody
    public String findByTitle(@RequestBody String title) {
        return postService.findByTitle(title);
    }

    @PostMapping("post/findByContent")
    @ResponseBody
    public String findByContent(@RequestBody String content) {
        return postService.findByContent(content);
    }

    @PostMapping("post/findByTag")
    @ResponseBody
    public String findByTag(@RequestBody Tag tag) {
        return postService.findByTag(tag);
    }

    @PostMapping("post/findByUser")
    @ResponseBody
    public String findByUser(@RequestBody User user) {
        return postService.findByUser(user);
    }

    @PostMapping("post/findByCategory")
    @ResponseBody
    public String findByCategory(@RequestBody Category category) {
        return postService.findByCategory(category);
    }

    // 게시물 총 조회

    @GetMapping("post/findAll")
    @ResponseBody
    public List<Post> findAll() {
        return postService.findAll();
    }

}
