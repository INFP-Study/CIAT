package com.infp.ciat.plant;

import com.infp.ciat.common.BaseTimeEntity;
import com.infp.ciat.user.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Plant extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String picture;

    @Column
    private double sunQuantity;

    @Column
    private double waterQuantity;

    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

}
