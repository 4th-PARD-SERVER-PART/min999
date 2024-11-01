package com.example.pard.Assignment5;

import com.example.pard.Assignment5.user.entity.User;
import com.example.pard.Assignment5.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final UserRepo userRepo;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        log.info("Google에서 받아온 UserRequest: " + oAuth2UserRequest);
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("OAuth에서 받아온 정보: " + oAuth2User.getAttributes());

        saveOrUpdateUser(oAuth2User);
        return oAuth2User;
    }

    private void saveOrUpdateUser(OAuth2User oAuth2User) {
        // 받아온 정보 Map 형태로 가져오기
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String name = (String) attributes.get("name");
        String num = (String) attributes.get("email");

        // 이메일로 중복 체크
        Optional<User> existingUser = userRepo.findByNum(num);

        // 사용자가 없다면 새로 저장
        if (existingUser.isEmpty()) {
            User newUser = User.builder()
                    .name(name)
                    .num(num)  // 이메일 중복 확인
                    .build();
            userRepo.save(newUser);
            log.info("새로운 사용자 저장됨: " + newUser);
        } else {
            log.info("이미 존재하는 사용자: " + existingUser.get());
        }
    }
}
