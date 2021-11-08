package com.infp.ciat.config.auth;

import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OAuth2DetailsService extends DefaultOAuth2UserService {
  @Autowired
  private AccountService accountService;

  /***
   * ouath2 로그인 성공시 호출
   * @param userRequest
   * @return
   * @throws OAuth2AuthenticationException
   */
  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2User oauth2_user = super.loadUser(userRequest);

    // ... 우선 구글로그인 부터 진행
    // 로그인 중인 서비스 코드를 구분 ex) 네이버로그인, 구글로그인
    String provider = userRequest.getClientRegistration().getRegistrationId();
    String providerId = oauth2_user.getAttribute("sub");

    // 회원가입이 되어 있지 않으면 회원가입 진행
    Account find_user = isSignUp(oauth2_user.getAttribute("email"));
    if(find_user == null) {
      SignupRequestDTO signupRequestDTO = SignupRequestDTO.builder()
              .email(oauth2_user.getAttribute("email"))
              .password("empty")
              .nickname(oauth2_user.getAttribute("name"))
              .provider(provider)
              .providerId(providerId)
              .build();
      Long save_id = accountService.signUp(signupRequestDTO);
      find_user = accountService.findUserById(save_id);
    }

    return new PrincipalDetails(find_user, oauth2_user.getAttributes());
  }

  /***
   * 회원가입이 이미 되었는지 검사
   * @param email
   */
  private Account isSignUp(String email){
    Optional<Account> find_user = accountService.findUserByEmailOrNull(email);
    if(!find_user.isPresent())
      return null;

    return find_user.get();


  }
}
