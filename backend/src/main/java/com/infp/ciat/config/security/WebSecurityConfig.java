package com.infp.ciat.config.security;

import com.infp.ciat.config.auth.OAuth2DetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 스프링시큐리티 설정
 */

@Transactional(readOnly = true)
@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2DetailsService oAuth2DetailesService;

    /***
     * default 패스워드 암호화알고리즘 사용 설정
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /***
     * 스프링시큐리티 http 설정
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/api/v1/user/signup").permitAll()
            .antMatchers("/api/v1/session/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/v1/menu").permitAll()
            .antMatchers(HttpMethod.GET, "/api/v1/menu/**").permitAll()
            .antMatchers("/healthcheck").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginProcessingUrl ("/api/v1/user/login")
            .usernameParameter("email")
            .passwordParameter("password")
            .failureHandler(new LoginFailHandler())
            .successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                    log.debug("[로그인 성공] -> " + authentication.getName());
                }
            })
            .and()
        .logout()
          .logoutUrl("/api/v1/user/logout")
          .permitAll()
          .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))
          .and()
                .sessionManagement()
                .invalidSessionUrl("/api/v1/session/invalid")
                .and()
        .cors()
            .configurationSource(corsConfigurationSource())
            .and()
        .oauth2Login()
                .userInfoEndpoint()
                    .userService(oAuth2DetailesService);
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("http://localhost:3000");
        corsConfiguration.addAllowedOriginPattern("http://localhost:8070");
        corsConfiguration.addAllowedOriginPattern("https://vuelogin.choicloudlab.com");
        corsConfiguration.addAllowedOriginPattern("https://ciat-frontend.choicloudlab.com");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addExposedHeader("JSESSIONID");
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return urlBasedCorsConfigurationSource;
    }
}

