package model.entity;

import lombok.Data;

@Data
public class Review {

    private Long id;

    private Long productId;

    private String createdEmail;

    private String updatedEmail;

    private Long grade;

    private String review;

    private Boolean deleteYN;
}
