package juhongBlog.juhongBlog.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "iamge")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment를 위함
    @Column(name = "image_id", unique = true, nullable = false)
    private Long id;

    @Column(length = 200, nullable = false)
    private String file_name;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Post.class)
    @JoinColumn(name = "post_id", updatable = false)
    private Post post;

    @Builder
    public Image(String file_name) {
        this.file_name = file_name;
    }
}
