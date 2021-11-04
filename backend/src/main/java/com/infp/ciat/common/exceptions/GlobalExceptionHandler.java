package com.infp.ciat.common.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /***
     * 회원가입 시 중복오류 핸들러
     * @param ex
     * @return
     */
    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<ErrorResponse> UserExistException(UserExistException ex){
        ErrorResponse response = new ErrorResponse(HttpStatus.CONFLICT, "회원가입 실패", ex.getMessage());
        return new ResponseEntity<>(response, response.getHttp_status());
    }
}
