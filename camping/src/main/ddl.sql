create database hw_camping;

use hw_camping;

# main page 에 보여줄 goods sample 을 위한 테이블
create table GOODS_SAMPLE(
    id int(10) not null auto_increment primary key,
    category varchar(20),
    name varchar(4000),
    image_url varchar(4000),
    price int(10)
);
