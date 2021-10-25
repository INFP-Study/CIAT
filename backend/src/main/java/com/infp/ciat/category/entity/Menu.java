package com.infp.ciat.category.entity;

import com.infp.ciat.common.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    private String url;

    private Long orders;

    private String isActivated;

    //categoryList.size() == 0 일 경우
    //private String isGetCategory;

    @OneToMany(mappedBy = "category_uid", fetch = FetchType.EAGER)
    private List<Category> categoryList;

//    @ManyToOne
//    @JoinColumn(name = "accountId")
//    private Account account;

    @Builder
    public Menu(String uid, String name, String icon, String url, Long orders, String isActivated) {
        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.isActivated = isActivated;
    }

}
