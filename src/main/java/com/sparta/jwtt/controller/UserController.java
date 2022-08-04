package com.sparta.jwtt.controller;

import com.sparta.jwtt.Dto.SignupRequestDto;
import com.sparta.jwtt.Dto.UserInfoDto;
import com.sparta.jwtt.Dto.commentRequestDto;
import com.sparta.jwtt.Dto.noticeDto;
import com.sparta.jwtt.model.UserRoleEnum;
import com.sparta.jwtt.model.notice;
import com.sparta.jwtt.security.jwt.UserDetailsImpl;
import com.sparta.jwtt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원 로그인 페이지
    @GetMapping("/api/member/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/api/member/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/api/member/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/api/member/login";
    }

    @PostMapping("/api/auth/post")
    public com.sparta.jwtt.controller.noticeC notice(noticeDto requestDto) {
        com.sparta.jwtt.controller.noticeC notice = null;
        noticeDto<notice> noticeDto = new noticeDto<>(true, notice, null);
        notice = new com.sparta.jwtt.controller.noticeC(requestDto) {
        };
        return notice;
    }

    @PostMapping("/api/auth/comment")
    public Comment<N> createComment(@RequestBody noticeDto requestDto){
        Comment<N> comment = new Comment<>();
        commentRequestDto.save(comment);
        return new Comment<N>();

    }

    

    // 회원 관련 정보 받기
    @PostMapping("/user/userinfo")
    @ResponseBody
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String nickname = userDetails.getUser().getNickname();
        UserRoleEnum role = userDetails.getUser().getRole();
        boolean isAdmin = (role == UserRoleEnum.ADMIN);

        return new UserInfoDto(nickname, isAdmin);
    }

    public class N {
    }
}