package com.camping.dev.model.vo;

import lombok.Data;

@Data
public class MemberRegisterVO {

    // 이메일
    private String email;

    // 비밀번호
    private String password;

    // 이름
    private String name;

    // 상태
    private String status;

}
