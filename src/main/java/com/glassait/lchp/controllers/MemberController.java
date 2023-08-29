package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.membre.Member;
import com.glassait.lchp.services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class MemberController {
    @Autowired
    private MembreService membreService;

    @RequestMapping(value = "api/member/{account_id}")
    public Member isClanMember(@PathVariable("account_id") String accountId) {
        return membreService.isClanMember(Integer.parseInt(accountId)).map(Member::new).orElse(null);
    }

    @RequestMapping(value = "api/member/update")
    public boolean updateClanMember() {
        return membreService.updateMembers();
    }
}
