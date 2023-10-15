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

    // 테스트
    @GetMapping("user")
    @ResponseBody
    public String test() {
        return "테스트";
    }

    @GetMapping("/")
    @ResponseBody
    public String test2() {
        return "테스트2";
    }

    // 회원가입
    @PostMapping("user/save")
    @ResponseBody // 이 어노테이션을 추가하여 문자열을 직접 반환할 수 있게 됩니다.
    public String userJoin(@RequestBody User user) {
        System.out.println("user : " + user.getName());
        userRepository.save(user);

        return "성공적으로 Join 되었습니다.";
    }

    // 로그인

    // 아이디 찾기

    // 비밀번호 찾기

    // 비밀번호 변경

    // 사용자 정보 조회

    /* jwt 관련 코드 시작*/

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


}
