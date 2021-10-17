package com.infp.ciat.category.entity;

import com.infp.ciat.common.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Menu extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uid;

    private String name;

    private String icon;

    private Long orders;

    private String isActivated;

    private String isGetCategory;

//    @ManyToOne
//    @JoinColumn(name = "accountId")
//    private Account account;

    @Builder
    public Menu(String uid, String name, String icon, Long orders, String isActivated, String isGetCategory) {
        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.orders = orders;
        this.isActivated = isActivated;
        this.isGetCategory = isGetCategory;
    }

}
