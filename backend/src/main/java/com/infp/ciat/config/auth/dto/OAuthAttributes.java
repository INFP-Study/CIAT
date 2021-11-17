package com.infp.ciat.config.auth.dto;

import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@ToString
@Getter
public class OAuthAttributes { // dto라고 보면된다.

  private final Map<String, Object> attributes;
  private final String nameAttributeKey;
  private final String name;
  private final String email;
//  private final String picture;

  @Builder
  public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
    this.attributes = attributes;
    this.nameAttributeKey = nameAttributeKey;
    this.name = name;
    this.email = email;
//    this.picture = picture;
  }


  /**
   * 구글, 깃허브, 카카오, 네이버, 페이스북 등에 따른 속성을 만들어준다.
   * @param registrationId 구글, 깃허브
   * @param userNameAttributeName
   * @param attributes 각 플랫폼에서 반환받은 유저 정보
   * @return 인증 객체
   */

  public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {

    log.info("요청 :: "+registrationId);
    log.info("유저이름 :: "+userNameAttributeName);
    log.info("속성 :: "+attributes);
    switch(registrationId){
      case "github":
        return ofGithub("login", attributes);
      case "google":
        return ofGoogle("name", attributes);
      default:
        throw new IllegalArgumentException("해당 로그인을 찾을 수 없습니다.");

    }
  }


  /**
   * OAuth2User에서 반환하는 사용자 정보는 Map 이기 때문에 값 하나하나를 변환해야한다.
   */

  // github
  private static OAuthAttributes ofGithub(String userNameAttributeName, Map<String, Object> attributes){
    return OAuthAttributes.builder()
      .name((String) attributes.get("login"))
      .email((String) attributes.get("email"))
//      .picture((String) attributes.get("avatar_url"))
      .attributes(attributes)
      .nameAttributeKey(userNameAttributeName)
      .build();
  }

  // google
  public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String,Object> attributes) {
    return OAuthAttributes.builder()
      .name((String) attributes.get("name"))
      .email((String) attributes.get("email"))
//      .picture((String) attributes.get("picture"))
      .attributes(attributes)
      .nameAttributeKey(userNameAttributeName)
      .build();
  }

  public Account toEntity() {
    return Account.builder()
      .email(email)
      .nickname(name)
      .role(Role.ROLE_USER)
      .password("empty")
      .build();
  }
}
