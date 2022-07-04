package com.camping.dev.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class GoodsDetailVO {

    // name : 상품이름
    private String name;

    // imageUrl : 상품 이미지 url
    private String imageUrl;

    // price : 상품 대여 가격
    private int price;

    // reviews : 리뷰 수
    private int reviews;

    // grade : 리뷰 평점
    private int grade;

    // goodsInfo : 상품 상세정보
    private String goodsInfo;

    // review : 리뷰내용
    private List<String> review;

    // reviewWriter : 리뷰작성자
    private String reviewWriter;

}
