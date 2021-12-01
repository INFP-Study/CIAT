package com.infp.ciat.board.entity;

import com.infp.ciat.common.BaseTimeEntity;
import com.infp.ciat.user.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ElementCollection
    @CollectionTable(name = "picture_list")
    private List<String> pictureList = new ArrayList<>();

    @Column(nullable = false)
    private String showYn = "Y";

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<BoardReply> replies;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<BoardLike> likes;

    @Builder
    public Board(String content, List<String> pictureList, Account account) {
        this.content = content;
        this.pictureList = pictureList;
        this.account = account;
    }

    @PrePersist
    public void prePersist() {
        this.showYn = this.showYn == null ? "Y" : this.showYn;
    }

}
