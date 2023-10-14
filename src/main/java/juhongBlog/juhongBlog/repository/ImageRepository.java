package juhongBlog.juhongBlog.repository;

import juhongBlog.juhongBlog.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
