package juhongBlog.juhongBlog.controller;


import juhongBlog.juhongBlog.domain.Category;
import juhongBlog.juhongBlog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // 카테고리 추가
    @PostMapping("category/create")
    @ResponseBody
    public String createCategory(Category category) {
        return categoryService.createCategory(category);
    }

    // 카테고리 총 조회
    @GetMapping("category/findAll")
    @ResponseBody
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    // 카테고리 삭제
    @GetMapping("category/deleteCategory/{id}")
    @ResponseBody
    public String deleteCategory(@PathVariable("id") Long id) {
        return categoryService.deleteCategory(id);
    }

}
