package juhongBlog.juhongBlog.service;

import juhongBlog.juhongBlog.domain.Tag;
import juhongBlog.juhongBlog.jwt.JwtTokenProvider;
import juhongBlog.juhongBlog.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final JwtTokenProvider jwtTokenProvider;

    // 태그 추가
    public String createTag(Tag tag, String token) {
        if(!jwtTokenProvider.validateToken(token)) {
            return "토큰 유효하지 않음";
        }
        tagRepository.save(Tag.builder()
                .name(tag.getName())
                .build()).getId();

        return "태그가 추가되었습니다.";
    }

    // 태그 삭제
    public String deleteTag(Long tag_id, String token) {
        if(!jwtTokenProvider.validateToken(token)) {
            return "토큰 유효하지 않음";
        }
        tagRepository.deleteById(tag_id);

        return "태그가 삭제되었습니다.";
    }
}
