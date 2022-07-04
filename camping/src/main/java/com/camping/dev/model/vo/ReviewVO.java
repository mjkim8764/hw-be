package com.camping.dev.model.vo;

import lombok.Data;

@Data
public class ReviewVO {

    // 리뷰 작성자
    public String email;

    // 리뷰 내용
    public String review;

    // 리뷰 평점
    public int grade;

}
