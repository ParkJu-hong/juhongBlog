package juhongBlog.juhongBlog.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment를 위함
    @Column(name = "post_id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    @Column(length = 15, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String created_at;

    @Column(length = 100, nullable = false)
    private String updated_at;

    @Builder
    public Post(String title, String content, String created_at, String updated_at) {
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}

