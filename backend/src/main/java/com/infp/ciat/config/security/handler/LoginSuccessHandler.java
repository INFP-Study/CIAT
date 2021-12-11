/***
 * deprecated
 */

//package com.infp.ciat.config.security;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@Slf4j
//public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        log.info("[login success] username: " + authentication.getName());
//        HttpSession session = request.getSession();
//        response.getWriter().write(session.getId());
//        response.getWriter().flush();
//
//        response.setStatus(HttpStatus.OK.value());
//    }
//}
