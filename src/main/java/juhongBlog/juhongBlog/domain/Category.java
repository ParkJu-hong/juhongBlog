package juhongBlog.juhongBlog.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment를 위함
    @Column(name = "category_id", unique = true, nullable = false)
    private Long id;

    @Column(length = 15, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Post> post = new ArrayList<>();

    @Builder
    public Category(String name) {
        this.name = name;
    }

}
