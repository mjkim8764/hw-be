package com.camping.dev.controller;

import com.camping.dev.model.vo.MemberRegisterVO;
import com.camping.dev.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    private final Logger logger = LoggerFactory.getLogger("MemberController's Log");

    @PostMapping("/register")
    public String registerMember(@RequestBody MemberRegisterVO memberRegisterVO) {
        String msg = memberService.registerMember(memberRegisterVO);
        return msg;
    }

}
