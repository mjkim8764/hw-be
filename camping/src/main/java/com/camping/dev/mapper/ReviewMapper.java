package com.camping.dev.mapper;

import org.apache.ibatis.annotations.Param;

public interface ReviewMapper {

    // 서버 재실행 시 리뷰테이블에 데이터가 있는지 확인
    public int getCount();

    // 초기 리뷰 데이터 적재
    public void insertInitData(@Param("prdId") String prdId,
                               @Param("userId") String userId,
                               @Param("grade") int grade,
                               @Param("review") String review);

    // 리뷰 테이블에 상품 테이블의 id update
    public void updateId();

}
