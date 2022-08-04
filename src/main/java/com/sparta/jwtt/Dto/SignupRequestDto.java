package com.sparta.jwtt.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter

@Getter
public class SignupRequestDto {
    private String nickname;
    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";
}