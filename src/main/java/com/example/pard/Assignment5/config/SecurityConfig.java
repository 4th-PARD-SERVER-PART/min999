package com.example.pard.Assignment5.config;



import com.example.pard.Assignment5.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


//cors는 설정ㄷ하는
//여기서는 지정
//cors를 가져와서
//bean이 등록됨 - > 가져와서 쓰는것.

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalOauth2UserService principalOauth2UserService;
    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable); //도메인끼리 보호학 해제
        http.addFilter(corsConfig.corsFilter());
        http.authorizeHttpRequests(au ->
                au.anyRequest().permitAll());
        http.oauth2Login(
                oauth -> oauth
                        .loginPage("/loginForm") //주소 프론트랑 맞춰야함
                        .defaultSuccessUrl("/home") //성공하면 /home으로
                        .userInfoEndpoint( //유저 정보를 prin에서 요청한 요구사항들을 받아온다.
                                userInfo ->
                                        userInfo.userService(principalOauth2UserService)
                        )

        );
        return http.build();
    }
}