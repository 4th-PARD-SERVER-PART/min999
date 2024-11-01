package com.assignment.seminar5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//axios를 통해서 우린 프론트와 소통함.
//*이 와일드카드 즉 다 들어가겠다 다 허용하겠다.

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*"); //("POST")이건 포스트만 허용하겠다. 여기서 delete를 뺴고 주기도 함
        source.registerCorsConfiguration("*",config);
        return new CorsFilter(source);
    }
}

//출저,헤더,자격증명요청,
//프론트랑 소통할떄 모든 환경설정을 여기서 한다.
//cross-origin url주소가 서로다른것들이 서로 허용,서로 통신할 수 있도록
//민규.com  민제.com
//원래는 보안상 안되는데
//데이터가 오고가려면 이런 설정들로 해줘야해
