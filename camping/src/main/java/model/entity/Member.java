package model.entity;

import lombok.Data;

@Data
public class Member {

    private String email;

    private String password;

    private String name;

    private Long grade;
}
