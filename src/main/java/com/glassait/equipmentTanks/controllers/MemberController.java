package com.glassait.equipmentTanks.controllers;

import com.glassait.equipmentTanks.abstracts.membre.Member;
import com.glassait.equipmentTanks.services.MembreService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class MemberController {
    @NonNull
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
