package com.infp.ciat.common.exceptions;

import org.springframework.http.HttpStatus;

/***
 * 오류발생시 응답
 */
public class ErrorResponse {
    private HttpStatus http_status;
    private String error;
    private String detail;

    public ErrorResponse(HttpStatus http_status, String error, String detail) {
        this.http_status = http_status;
        this.error = error;
        this.detail = detail;
    }

    public HttpStatus getHttp_status() {
        return http_status;
    }
}
