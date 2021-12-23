package com.infp.ciat.config.security;

import com.infp.ciat.config.auth.OAuth2DetailsService;
import com.infp.ciat.config.security.filter.JWTCheckFilter;
import com.infp.ciat.config.security.filter.JWTFilter;
import com.infp.ciat.config.security.jwt.JWTUtils;
import com.infp.ciat.user.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/***
 * 스프링시큐리티 설정
 */

@Transactional(readOnly = true)
@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountService accountService;
    @Autowired
    private OAuth2DetailsService oAuth2DetailesService;
    @Autowired
    private JWTUtils jwtUtils;

    /***
     * default 패스워드 암호화알고리즘 사용 설정
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/css/**, /static/js/**, *.ico"); // swagger
        web.ignoring().antMatchers(
                "/v2/api-docs/**", "/configuration/ui/**",
                "/swagger-resources/**", "/configuration/security/**",
                "/swagger-ui.html/**", "/webjars/**", "/swagger/**");
    }

    /***
     * 스프링시큐리티 http 설정
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 필터등록
        http.addFilter(new JWTFilter(authenticationManagerBean(), jwtUtils))
                .addFilterBefore(new JWTCheckFilter(authenticationManagerBean(),
                        accountService, jwtUtils), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers("/api/v1/user/signin").permitAll()
                .antMatchers("/api/v1/user/signup").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/feed").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/feed/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/feeds").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/feeds/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/menu").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/menu/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/categories").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/category/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/gardenList").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/gardenDtl/**").permitAll()
                .antMatchers(HttpMethod.GET, "/swagger-ui.html/**").permitAll()
                .antMatchers("/healthcheck").permitAll()

                .anyRequest().authenticated()
                .and()
                .cors()
                .configurationSource(corsConfigurationSource());
//            .and()
//        .oauth2Login().userInfoEndpoint().userService(oAuth2DetailesService);
    }

    /***
     * 기본 authenticationManger를 Bean으로 등록한다.
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // reference: https://stackoverflow.com/questions/37897523/axios-get-access-to-response-header-fields
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:3000");
        corsConfiguration.addAllowedOrigin("http://localhost:8070");
        corsConfiguration.addAllowedOrigin("https://vuelogin.choicloudlab.com");
        corsConfiguration.addAllowedOrigin("https://ciat-frontend.choicloudlab.com");
        corsConfiguration.setAllowedHeaders(Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers"));
//        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return urlBasedCorsConfigurationSource;
    }
}

