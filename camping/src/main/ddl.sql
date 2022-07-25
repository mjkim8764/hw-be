create database hw_camping;

use hw_camping;

# DB 데이터 삭제
truncate GOODS;
truncate MEMBER;
truncate GOODS_SAMPLE;

# 테이블 삭제
drop table GOODS_SAMPLE;

# Goods 테이블
create table GOODS(
    ID int(10) not null auto_increment primary key,
    PRD_ID_TMP varchar(50) default '-1',
    CATEGORY varchar(50),
    NAME varchar(50),
    IMAGE_URL varchar(4000),
    PRICE int(10),
    LENDER_EMAIL varchar(50),
    REVIEWS int(10),
    GRADE double
);

# Review 테이블
create table REVIEW(
    ID int(10) not null auto_increment primary key,
    PRD_ID int(10),
    PRD_ID_TMP varchar(50) default '0',
    EMAIL varchar(100),
    GRADE int(10),
    REVIEW varchar(4000)
);

# Member 테이블
create table MEMBER(
    EMAIL varchar(50) not null primary key,
    PASSWORD varchar(255) not null,
    NAME varchar(50) not null,
    TRADED int(10) default 0,
    GRADE double default 3
);

# Rental 테이블
CREATE TABLE RENTAL(
    ID INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    PRD_ID INT(10),
    LENDER_EMAIL VARCHAR(20),
    BORROWER_EMAIL VARCHAR(20),
    RENTAL_START_DATE VARCHAR(20),
    RENTAL_END_DATE VARCHAR(20),
    MESSAGE VARCHAR(4000),
    RENT_STATUS VARCHAR(20)
);

# Code 테이블
CREATE TABLE CODE(
    ID INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CODE_NAME VARCHAR(50),
    CODE_DEPTH VARCHAR(50),
    CODE_DETAIL VARCHAR(50)
);

