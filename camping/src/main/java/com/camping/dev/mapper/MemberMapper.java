package com.camping.dev.mapper;

import com.camping.dev.model.entity.Member;

public interface MemberMapper {

    public void insertMemberInfo(Member member);

    public int searchByEmail(String email);

}
