package com.camping.dev.model.entity;

import lombok.Data;

@Data
public class Rental {

    private Long id;

    private Long productId;

    private String lenderEmail;

    private String borrowerEmail;

    private String rentalStartDate;

    private String rentalEndDate;

    private String message;

    private String rentStatus;

}
