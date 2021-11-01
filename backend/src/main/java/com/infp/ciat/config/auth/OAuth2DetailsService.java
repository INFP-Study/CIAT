package com.infp.ciat.config.auth;

import com.infp.ciat.config.auth.dto.OAuthAttributes;
import com.infp.ciat.config.auth.dto.SessionAccount;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Service
public class OAuth2DetailsService extends DefaultOAuth2UserService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private HttpSession httpSession;
  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

    OAuth2UserService delegate = new DefaultOAuth2UserService();
    OAuth2User oAuth2User = delegate.loadUser(userRequest);

    // 로그인 중인 서비스 코드를 구분 ex) 네이버로그인, 구글로그인
    String registrationId = userRequest.getClientRegistration().getRegistrationId();

    // 로그인 진행할때 pk: 구글은 기본제공, 네이버/카카오 지원안함
    String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

    // OAuth2User class의 attribute를 담을 class이다.
    OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

    Account account = saveOrUpdate(attributes);

    //세션에 사용자 정보를 저장하기 위한 dto 클래스
    httpSession.setAttribute("account", new SessionAccount(account));

    return new DefaultOAuth2User(
      Collections.singleton(new SimpleGrantedAuthority(account.getRole().name())),
      attributes.getAttributes(),
      attributes.getNameAttributeKey());
  }

  /**
   * TODO: 이름에 해당하는 유저가 있으면 업데이트하고, 없을 경우 입력함.
   * email이 아니라 바뀔 수 있는 이름을 키로 잡은 이유는 카카오 같은 경우 이메일 없이도 가입이 가능하고,
   * 깃허브 같은 경우는 이메일을 반환하지 않아서, 예제 처리를 위해서 일단 공통으로 모두 무조건 반환하는 이름을 통해
   * 처리를 했음.
   * @param attributes
   * @return
   */
  private Account saveOrUpdate(OAuthAttributes attributes) {
    Account account = accountRepository.findByEmail(attributes.getEmail())
//      .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
      .map(entity -> entity.update(attributes.getName()))
      .orElse(attributes.toEntity());

    return accountRepository.save(account);
  }
}

//  @Transactional
//  protected Account saveAccount(OAuthAttributes attributes) {
//
//    System.out.println("SAVE USER");
//
//    if(accountRepository.findByEmail(attributes.getEmail()) != null) {
//      throw new UserEmailConflictException();
//    } else {
//      Account user = attributes.toEntity();
//      return accountRepository.save(user);
//    }
//  }
//}



//  @Override
//  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//
//    //userRequest 안에 user의 정보를 준다
//
//    OAuth2User oAuth2User = super.loadUser(userRequest);
//
//    System.out.println(oAuth2User.getAttributes());
//
//    Map<String, Object> accountInfo = oAuth2User.getAttributes();
//// sub, family_name, email, name
//    String email = (String) accountInfo.get("email");
//    String password = new BCryptPasswordEncoder().encode(UUID.randomUUID().toString());
//    String nickname = "google_" + (String) accountInfo.get("sub"); // sub=id
//
//
//    // 로그인 -> sns -> 회원가입  ok
//    // sns -> 회원가입? -> 이상,,,
//
//    //회원 정보가 있는지 없는지 확인
//    Account accountEntity = accountRepository.findByEmail(email);
//
//    if (accountEntity == null) {
//      // google 최초 로그인
//
//      Account account = Account.builder()
//        .email(email)
//        .password(password)
//        .nickname(nickname)
//        .role(Role.ROLE_USER)
//        .build();
//
//      //OAuth2User type 을 session 에 저장한다
//      return new PrincipalDetails(accountRepository.save(account));
//
//    } else {
//      // google로 이미 회원가입 되어있음
//      return new PrincipalDetails(accountEntity,oAuth2User.getAttributes());
//    }
//  }
//}
