package juhongBlog.juhongBlog.service;

import juhongBlog.juhongBlog.domain.Tag;
import juhongBlog.juhongBlog.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    // 태그 추가
    public Long createTag(Tag tag) {
        return tagRepository.save(Tag.builder()
                .name(tag.getName())
                .build()).getId();
    }

    // 태그 삭제
    public String deleteTag(Long tag_id) {
        tagRepository.deleteById(tag_id);

        return "태그가 삭제되었습니다.";
    }
}
