package juhongBlog.juhongBlog.controller;

import juhongBlog.juhongBlog.domain.User;
import juhongBlog.juhongBlog.jwt.JwtTokenProvider;
import juhongBlog.juhongBlog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    // 사용자 정보 조회
    @GetMapping("/findUser")
    @ResponseBody
    public User findUser(@RequestBody Map<String, String> user) {
        if(user.get("email") != null) {
            User userFined = userRepository.findByEmail(user.get("email"))
                    .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 userId 입니다."));
            User result = User.builder()
                    .email(userFined.getEmail())
                    .password("")
                    .id(userFined.getId())
                    .roles(userFined.getRoles())
                    .name(userFined.getName())
                    .build();

            return result;
        }else if(user.get("name") != null) {
            User userFined = userRepository.findByName(user.get("name"))
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
    @PostMapping("/join")
    @ResponseBody
    public Long join(@RequestBody Map<String, String> user) {
        return userRepository.save(User.builder()
                .email(user.get("email"))
                .password(passwordEncoder.encode(user.get("password")))
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .name(user.get("name"))
                .build()).getId();
    }

    @GetMapping("/test")
    @ResponseBody
    public String testOne(@RequestHeader("X-AUTH-TOKEN") String token) {
        if( jwtTokenProvider.validateToken(token)) {
            return "토큰 유효함";
        }else {
            return "토큰 유효하지 않음";
        }
    }

    // 로그인
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }

    // 비밀번호 변경
    @PostMapping("/findEmail")
    @ResponseBody
    public String findPassWord(@RequestBody Long userId, String beforePassword,String afterPassWord) {
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
