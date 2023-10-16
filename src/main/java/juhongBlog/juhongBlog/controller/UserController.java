package juhongBlog.juhongBlog.controller;

import juhongBlog.juhongBlog.domain.User;
import juhongBlog.juhongBlog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    // 사용자 정보 조회
    @GetMapping("/findUser")
    @ResponseBody
    public User findUser(@RequestBody Map<String, String> user) {
        return userService.findUser(user.get("email"), user.get("name"));
    }

    // 회원가입
    @PostMapping("/join")
    @ResponseBody
    public Long join(@RequestBody Map<String, String> user) {
        return userService.join(user.get("email"), user.get("password"), user.get("name"));
    }

    // 로그인
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody Map<String, String> user) {
        return userService.login(user.get("email"), user.get("password"));
    }

    // 비밀번호 변경
    @PostMapping("/chagepassword")
    @ResponseBody
    public String changePassWord(@RequestBody Map<String, String> user) {
        return userService.changePassword(Long.parseLong(user.get("userId")), user.get("beforePassWord"), user.get("afterPassWord"));
    }

}
