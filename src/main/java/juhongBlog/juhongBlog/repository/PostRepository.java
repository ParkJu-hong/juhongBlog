package juhongBlog.juhongBlog.repository;

import juhongBlog.juhongBlog.domain.Category;
import juhongBlog.juhongBlog.domain.Post;
import juhongBlog.juhongBlog.domain.Tag;
import juhongBlog.juhongBlog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUser(User user);
    Optional<Post> findByCategory(Category category);
    Optional<Post> findByTag(Tag tag);
    Optional<Post> findByTitle(String title);
    Optional<Post> findByContent(String content);

}
