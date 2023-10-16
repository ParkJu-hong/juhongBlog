package juhongBlog.juhongBlog.service;

import juhongBlog.juhongBlog.domain.User;
import juhongBlog.juhongBlog.jwt.JwtTokenProvider;
import juhongBlog.juhongBlog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    // 사용자 정보 조회
    public User findUser(String email, String name) {
        if(email != null) {
            User userFined = userRepository.findByEmail(email)
                    .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 userId 입니다."));
            User result = User.builder()
                    .email(userFined.getEmail())
                    .password("")
                    .id(userFined.getId())
                    .roles(userFined.getRoles())
                    .name(userFined.getName())
                    .build();

            return result;
        }else if(name != null) {
            User userFined = userRepository.findByName(name)
                    .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 userId 입니다."));
            User result = User.builder()
                    .email(userFined.getEmail())
                    .password("")
                    .id(userFined.getId())
                    .roles(userFined.getRoles())
                    .name(userFined.getName())
                    .build();

            return result;
        }else {
            return new User();
        }
    }

    // 회원가입
    public Long join(String email, String password, String name){
        return userRepository.save(User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .name(name)
                .build()).getId();
    }

    public String login(String email, String password){
        User member = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }

    // 비밀번호 변경
    public String changePassword(Long userId, String beforePassword,String afterPassWord){
        User member = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 userId 입니다."));
        if (!passwordEncoder.matches(beforePassword, member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        if(userId == member.getId()){
            userRepository.save(User.builder()
                    .email(member.getEmail())
                    .name(member.getName())
                    .id(member.getId())
                    .roles(member.getRoles())
                    .password(afterPassWord)
                    .build()
            );
            return "비밀번호가 정상적으로 변경되었습니다.";
        }else {
            return "일치하는 userId가 없습니다.";
        }
    }

}

/*
* 토큰 검증 하는 법
* //
//    @GetMapping("/test")
//    @ResponseBody
//    public String testOne(@RequestHeader("X-AUTH-TOKEN") String token) {
//        if( jwtTokenProvider.validateToken(token)) {
//            return "토큰 유효함";
//        }else {
//            return "토큰 유효하지 않음";
//        }
//    }
* */
