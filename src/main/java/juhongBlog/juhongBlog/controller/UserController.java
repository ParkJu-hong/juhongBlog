package juhongBlog.juhongBlog.controller;

import juhongBlog.juhongBlog.domain.User;
import juhongBlog.juhongBlog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("user/save")
    @ResponseBody // 이 어노테이션을 추가하여 문자열을 직접 반환할 수 있게 됩니다.
    public String userJoin(@RequestBody User user) {
        System.out.println("user : " + user.getName());
        userRepository.save(user);

        return "성공적으로 Join 되었습니다.";
    }
}
