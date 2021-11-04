package com.infp.ciat.user.entity;

import com.infp.ciat.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

/***
 * 유저 Entity
 */

@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private String provider;

    @Column(name="providerId")
    private String providerId;

    @Builder
    public Account(String email, String nickname, String password, Role role, String provider, String providerId) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

  public Account update(String name) {
    this.nickname = name;
    return this;
  }
}
