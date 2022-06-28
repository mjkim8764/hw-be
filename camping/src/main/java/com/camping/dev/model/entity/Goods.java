package com.camping.dev.model.entity;

import lombok.Data;

@Data
public class Goods {

    private Long id;

    private String name;

    private String imageUrl;

    private Long price;

    private Long view;

    private String registerDate;

    private Long count;

    private Boolean rentYN;

}
