package com.infp.ciat.user.controller;

import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.controller.dto.response.SignUpResponse;
import com.infp.ciat.user.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> SignUp(@Valid @RequestBody SignupRequestDTO requestDTO) {
        log.info("------------------- 회원가입 요청 -----------------------");

        Long created_id = accountService.SignUp(requestDTO);
        return new ResponseEntity<>(new SignUpResponse(created_id), HttpStatus.CREATED);
    }
}
