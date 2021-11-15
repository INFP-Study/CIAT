package com.infp.ciat.user.entity;

import lombok.Getter;

/***
 * 회원 Role
 */

public enum Role {
    ROLE_ADMIN("ROLE_ADMIN", "관리자"),
    ROLE_USER("ROLE_USER", "일반 사용자");

    private String role;
    private String description;


    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    Role(String role, String description) {
        this.role = role;
        this.description = description;
    }
}
