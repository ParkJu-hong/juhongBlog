package juhongBlog.juhongBlog.service;


import juhongBlog.juhongBlog.domain.*;
import juhongBlog.juhongBlog.jwt.JwtTokenProvider;
import juhongBlog.juhongBlog.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    private final ImageRepository imageRepository;


    // 게시물 게시
    public String createPost(Post post, Long userId, Long categoryId, Long tagId, List<Image> images, String token){
        if(!jwtTokenProvider.validateToken(token)) {
            return "토큰 유효하지 않음";
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long _userId;
        Long _categoryId;
        Long _tagId;
        List<Image> _images = new ArrayList<>();

        if(userRepository.findById(userId).isEmpty()) {
            _userId = userId;
        }else {
            return "해당 userId가 없습니다.";
        }

        if(categoryRepository.findById(categoryId).isEmpty()) {
            _categoryId = categoryId;
        }else {
            return "해당 categoryId가 없습니다.";
        }

        if(tagRepository.findById(tagId).isEmpty()) {
            _tagId = tagId;
        }else {
            return "해당 tagId가 없습니다.";
        }

        if(images != null) {
            for(int i = 0; i < images.size(); i++) {
                Image _image = imageRepository.save(images.get(i));
                if(!imageRepository.findById(_image.getId()).isEmpty()) {
                    _images.add(_image);
                }else {
                    return "이미지 저장시 오류가 발생했습니다.";
                }
            }
        }
        List<Tag> __tag = new ArrayList<>();
        __tag.add(tagRepository.findById(_tagId).get());
        postRepository.save(Post.builder()
                .title(post.getTitle())
                .content(post.getContent())
                        .created_at(format.format(date))
                        .updated_at(format.format(date))
                        .user(userRepository.findById(_userId).get())
                        .category(categoryRepository.findById(_categoryId).get())
                        .tag(__tag)
                        .image(_images)
                        .build()
                );

       return "post 저장 완료";
    }

    // 게시물 수정
    public String updatePost(Long postId, Post post, Long userId, Long categoryId, Long tagId, List<Image> images, String token){
        if(!jwtTokenProvider.validateToken(token)) {
            return "토큰 유효하지 않음";
        }

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long _userId;
        Long _categoryId;
        Long _tagId;
        List<Image> _images = new ArrayList<>();

        if(userRepository.findById(userId).isEmpty()) {
            _userId = userId;
        }else {
            return "해당 userId가 없습니다.";
        }

        if(categoryRepository.findById(categoryId).isEmpty()) {
            _categoryId = categoryId;
        }else {
            return "해당 categoryId가 없습니다.";
        }

        if(tagRepository.findById(tagId).isEmpty()) {
            _tagId = tagId;
        }else {
            return "해당 tagId가 없습니다.";
        }

        if(images != null) {
            for(int i = 0; i < images.size(); i++) {
                Image _image = imageRepository.save(images.get(i));
                if(!imageRepository.findById(_image.getId()).isEmpty()) {
                    _images.add(_image);
                }else {
                    return "이미지 저장시 오류가 발생했습니다.";
                }
            }
        }
        List<Tag> __tag = new ArrayList<>();
        __tag.add(tagRepository.findById(_tagId).get());

        postRepository.save(Post.builder()
                .id(postId)
                .title(post.getTitle())
                .content(post.getContent())
                .updated_at(format.format(date))
                .user(userRepository.findById(_userId).get())
                .category(categoryRepository.findById(_categoryId).get())
                .tag(__tag)
                .image(_images)
                .build()
        );

        return "post 수정 완료";
    }

    // 게시물 삭제
    public String deletePost (Long postId, String token) {
        if(!jwtTokenProvider.validateToken(token)) {
            return "토큰 유효하지 않음";
        }
        postRepository.deleteById(postId);
        return "post 삭제 완료";
    }

    // 게시물 검색 (부분조회)
    public String findByTitle (String title) {
        if(postRepository.findByTitle(title).isPresent()){
            return postRepository.findByTitle(title).get().toString();
        }else {
            return "조회 결과 없습니다.";
        }
    }
    public String findByContent (String content) {
        if(postRepository.findByContent(content).isPresent()){
            return postRepository.findByContent(content).get().toString();
        }else {
            return "조회 결과 없습니다.";
        }
    }

    public String findByTag (Tag tag) {
        if(postRepository.findByTag(tag).isPresent()){
            return postRepository.findByTag(tag).get().toString();
        }else {
            return "조회 결과 없습니다.";
        }
    }

    public String findByUser (User user) {
        if(postRepository.findByUser(user).isPresent()){
            return postRepository.findByUser(user).get().toString();
        }else {
            return "조회 결과 없습니다.";
        }
    }

    public String findByCategory (Category category) {
        if(postRepository.findByCategory(category).isPresent()){
            return postRepository.findByCategory(category).get().toString();
        }else {
            return "조회 결과 없습니다.";
        }
    }

    // 게시물 총 조회

    public List<Post> findAll () {
        return postRepository.findAll();
    }
}
