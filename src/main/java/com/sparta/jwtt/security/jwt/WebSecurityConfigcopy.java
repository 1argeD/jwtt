package com.sparta.jwtt.security.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

public interface WebSecurityConfigcopy {
    @Bean
    AuthenticationManager authenticationManagerBean() throws Exception;
}
