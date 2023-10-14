package juhongBlog.juhongBlog.repository;

import juhongBlog.juhongBlog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
