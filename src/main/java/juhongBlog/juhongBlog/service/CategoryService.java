package juhongBlog.juhongBlog.service;


import juhongBlog.juhongBlog.domain.Category;
import juhongBlog.juhongBlog.repository.CategoryRepository;
import juhongBlog.juhongBlog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    // 카테고리 추가
    public String createCategory(Category category) {

        categoryRepository.save(Category.builder()
                .name(category.getName())
                .build());

        return "카테고리가 추가되었습니다.";
    }

    // 카테고리 총 조회
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // 카테고리 삭제
    public String deleteCategory(Long categoryid) {
        categoryRepository.deleteById(categoryid);
        return "카테고리가 삭제되었습니다.";
    }
}
