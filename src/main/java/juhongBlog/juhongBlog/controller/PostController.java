package juhongBlog.juhongBlog.controller;


import juhongBlog.juhongBlog.domain.*;
import juhongBlog.juhongBlog.service.CategoryService;
import juhongBlog.juhongBlog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final CategoryService categoryService;


    // 게시물 게시
    @PostMapping("/user/post/create")
    @ResponseBody
    public String createPost(@RequestBody Post post, Long userId, Long categoryId, Long tagId, List<Image> images, @RequestHeader("X-AUTH-TOKEN") String token) {
        return postService.createPost(post, userId, categoryId, tagId, images, token);
    }

    // 게시물 수정
    @PostMapping("/user/post/update")
    @ResponseBody
    public String updatePost(Long postId, Post post, Long userId, Long categoryId, Long tagId, List<Image> images, @RequestHeader("X-AUTH-TOKEN") String token) {
        return postService.updatePost(postId, post, userId, categoryId, tagId, images, token);
    }

    // 게시물 삭제
    @GetMapping("/admin/post/delete/{id}")
    @ResponseBody
    public String deletePost(@PathVariable("id") Long id, @RequestHeader("X-AUTH-TOKEN") String token) {
        return postService.deletePost(id, token);
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
