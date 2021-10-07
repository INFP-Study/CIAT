package com.infp.ciat.user.entity;

import com.infp.ciat.common.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/***
 * 유저 Entity
 */
@Builder
@NoArgsConstructor
@Getter
@Entity
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

    @Builder
    public Account(Long id, String email, String nickname, String password, Role role) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }
}
