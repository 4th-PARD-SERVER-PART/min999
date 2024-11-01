package com.example.pard.Assignment5.config;

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