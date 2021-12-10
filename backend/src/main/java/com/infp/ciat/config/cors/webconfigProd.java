package com.infp.ciat.config.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webconfigProd implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost:3000")
                .allowedOriginPatterns("http://localhost:8070")
                .allowedOriginPatterns("https://vuelogin.choicloudlab.com")
                .allowedOriginPatterns("https://ciat-frontend.choicloudlab.com")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("*");
    }
}