package com.infp.ciat.user.controller;

import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.user.controller.dto.request.ResetPasswordRequestDTO;
import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.controller.dto.response.LoginSuccessResponse;
import com.infp.ciat.user.controller.dto.response.SignUpResponse;
import com.infp.ciat.user.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
public class AccountController {
    private final AccountService accountService;

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromMail;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signUp(@Valid @RequestBody SignupRequestDTO requestDTO) {

        log.info("------------------- 회원가입 요청 -----------------------");

        Long created_id = accountService.signUp(requestDTO);
        return new ResponseEntity<>(new SignUpResponse(created_id), HttpStatus.CREATED);
    }

    @SneakyThrows
    @PostMapping("/resetPassword")
    public void resetPassword(@RequestBody ResetPasswordRequestDTO requestDTO)  {

        System.out.println("email: " + requestDTO.getEmail());
        System.out.println("fromMail: " + fromMail);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setFrom(fromMail);
        mimeMessageHelper.setTo(requestDTO.getEmail());
        mimeMessageHelper.setSubject("[ciat] 임시 비밀번호 안내");

        Random random = new Random();
        String code = "";
        for (int i = 0; i < 4; i++) {
            code += random.nextInt(10);
        }

        StringBuilder body = new StringBuilder();

        body.append("3시간 안에 코드를 입력해주세요.\n");
        body.append("코드: " + code);

        mimeMessageHelper.setText(body.toString(), true);
        javaMailSender.send(mimeMessage);

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
