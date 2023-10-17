package juhongBlog.juhongBlog.controller;


import juhongBlog.juhongBlog.domain.Tag;
import juhongBlog.juhongBlog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    // 태그 추가
    @PostMapping("/user/tag/create")
    @ResponseBody
    public String createTag(Tag tag, @RequestHeader("X-AUTH-TOKEN") String token) {
        return tagService.createTag(tag, token);
    }

    // 태그 삭제
    @GetMapping("/user/tag/deleteTag/{id}")
    @ResponseBody
    public String deleteTag(@PathVariable("id") Long id, @RequestHeader("X-AUTH-TOKEN") String token) {
        return tagService.deleteTag(id, token);
    }
}
