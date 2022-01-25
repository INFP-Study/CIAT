package com.infp.ciat.config.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("dev")
public class webconfigDev implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOrigins(
                        "http://localhost:3000",
                        "https://vuelogin.choicloudlab.com",
                        "http://localhost:8070",
                        "https://ciat-dev.choicloudlab.com",
                        "https://ciat.choicloudlab.com",
                        "https://smtp.naver.com",
                        "https://smtp.naver.com:465"
                )
                .allowedMethods("*");
    }
}
