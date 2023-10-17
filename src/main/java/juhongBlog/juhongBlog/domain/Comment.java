package juhongBlog.juhongBlog.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment를 위함
    @Column(name = "comment_id", unique = true, nullable = false)
    private Long id;

    @Column(length = 200, nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String created_at;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Post.class)
    @JoinColumn(name = "post_id", updatable = false)
    private Post post;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = User.class)
    @JoinColumn(name = "user_id", updatable = false)
    private User user;

    @Builder
    public Comment(String content, User user, Post post) {
        if(user != null) {
            this.user = user;
        }

        if(post != null) {
            this.post = post;
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.content = content;
        this.created_at = format.format(date);;
    }

}
