package com.infp.ciat.category.entity;

import com.infp.ciat.common.BaseTimeEntity;
import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@Getter
@Entity
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uid;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Long orders;

    @Column(nullable = false, length = 2)
    private String isActivated;


//    @ManyToOne
//    @JoinColumn(name = "menu_uid")
//    private Menu menu;
//
//    @ManyToOne
//    @JoinColumn(name = "accountId")
//    private Account account;


}
