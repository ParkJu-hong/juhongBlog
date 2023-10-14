package juhongBlog.juhongBlog.repository;

import juhongBlog.juhongBlog.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
