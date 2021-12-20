package com.infp.ciat.feed.entity;

import com.infp.ciat.common.BaseTimeEntity;
import com.infp.ciat.feed.controller.dto.FeedDto;
import com.infp.ciat.user.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Feed extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "picture_list")
    private List<String> pictureList = new ArrayList<>();

    @Column(nullable = false)
    private String showYn = "Y";

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @OneToMany(mappedBy = "feed", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<FeedReply> replies;

    @Builder
    public Feed(String content, List<String> pictureList, String showYn, Account account) {
        this.content = content;
        this.pictureList = pictureList;
        this.showYn = showYn;
        this.account = account;
    }

    @PrePersist
    public void prePersist() {
        this.showYn = this.showYn == null ? "Y" : this.showYn;
    }

    public Feed update(String content) {
        this.content = content;
        return this;
    }

    public boolean isSameContent(String content) {
        return this.content.equals(content);
    }

    public void delete() {
        this.showYn = "N";
    }

}
