package juhongBlog.juhongBlog.repository;

import juhongBlog.juhongBlog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
