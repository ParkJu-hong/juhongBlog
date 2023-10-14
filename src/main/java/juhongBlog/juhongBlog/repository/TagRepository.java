package juhongBlog.juhongBlog.repository;

import juhongBlog.juhongBlog.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
