/***
 * deprecated
 */

//package com.infp.ciat.user.controller;
//
//import com.infp.ciat.common.exceptions.ErrorResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RequestMapping("/api/v1/session")
//@RestController
//@Slf4j
//public class SessionController {
//
//    /***
//     * 유효하지 않는 세션
//     * @return
//     */
//    @GetMapping("/invalid")
//    public ResponseEntity<ErrorResponse> invalid(){
//        log.error("Session is invalid");
//        ErrorResponse response = new ErrorResponse(HttpStatus.UNAUTHORIZED, "세션만료", "세션이 만료되었습니다");
//        return new ResponseEntity<>(response, response.getHttp_status());
//    }
//}
