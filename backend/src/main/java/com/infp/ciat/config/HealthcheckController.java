package com.infp.ciat.config;

import org.springframework.web.bind.annotation.GetMapping;

/***
 * 쿠버네티스 healthcheck 컨트롤러
 */
public class HealthcheckController {
    @GetMapping("/healthcheck")
    public String Healthcheck() {
        return "pingpong";
    }
}
