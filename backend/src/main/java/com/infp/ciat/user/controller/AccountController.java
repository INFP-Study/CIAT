package com.infp.ciat.user.controller;

import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.controller.dto.response.LoginSuccessResponse;
import com.infp.ciat.user.controller.dto.response.SignUpResponse;
import com.infp.ciat.user.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@Valid @RequestBody SignupRequestDTO requestDTO) {

        log.info("------------------- 회원가입 요청 -----------------------");

        Long created_id = accountService.signUp(requestDTO);
        return new ResponseEntity<>(new SignUpResponse(created_id), HttpStatus.CREATED);
    }

    /***
     * 회원가입 성공후 response
     * @param user
     * @return
     */
    @GetMapping("/success")
    public ResponseEntity<LoginSuccessResponse> login_success(@AuthenticationPrincipal PrincipalDetails user) {
        return new ResponseEntity<>(new LoginSuccessResponse(user.getUsername()), HttpStatus.OK);
    }
}
