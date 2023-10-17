package juhongBlog.juhongBlog.controller;


import juhongBlog.juhongBlog.domain.Tag;
import juhongBlog.juhongBlog.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    // 태그 추가
    @PostMapping("tag/create")
    @ResponseBody
    public Long createTag(Tag tag) {
        return tagService.createTag(tag);
    }

    // 태그 삭제
    @GetMapping("tag/deleteTag/{id}")
    @ResponseBody
    public String deleteTag(@PathVariable("id") Long id) {
        return tagService.deleteTag(id);
    }
}
