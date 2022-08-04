package com.sparta.jwtt.security.jwt.provider;

import com.sparta.jwtt.Dto.UserRepository;
import com.sparta.jwtt.model.Users;
import com.sparta.jwtt.security.jwt.JwtDecoder;
import com.sparta.jwtt.security.jwt.JwtPreProcessingToken;
import com.sparta.jwtt.security.jwt.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Setter
@Component
@RequiredArgsConstructor
public class JWTAuthProvider implements AuthenticationProvider {

    private final JwtDecoder jwtDecoder;

    private final UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String token = (String) authentication.getPrincipal();
        String nickname = jwtDecoder.decodeNickname(token);

//         TODO: API 사용시마다 매번 User DB 조회 필요
//          -> 해결을 위해서는 UserDetailsImpl 에 User 객체를 저장하지 않도록 수정
//          ex) UserDetailsImpl 에 userId, username, role 만 저장
//            -> JWT 에 userId, username, role 정보를 암호화/복호화하여 사용
        Users users = userRepository.findByNickname(nickname)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + nickname));;
        UserDetailsImpl userDetails = new UserDetailsImpl(users);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtPreProcessingToken.class.isAssignableFrom(authentication);
    }
}
