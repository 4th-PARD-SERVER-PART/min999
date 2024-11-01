package com.assignment.seminar5;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

// auth통해서 유저정보 받아오면
// 이걸 받아오는 print해주는 코드
@Service
@Slf4j // 로그창에 뭘 띄우고싶을떄
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    @Override //이미 있는거임
    public OAuth2User loadUser(//유저 정보를 받아올떄 쓰는 코드
        OAuth2UserRequest oAuth2UserRequest
    ) throws OAuth2AuthenticationException{
        log.info("google에서 받아온 UserRequest : " + oAuth2UserRequest);
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("oauth에서 받아온 정보: " + oAuth2User.getAttributes());
        return super.loadUser(oAuth2UserRequest);
    }
}
