package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.membre.Membre;
import com.glassait.lchp.services.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping(value = "api/member/{account_id}")
@RestController
public class MemberController {
    @Autowired
    private MembreService membreService;

    @GetMapping
    public Membre isClanMember(@PathVariable("account_id") String accountId) {
        return membreService.isClanMember(Integer.parseInt(accountId)).map(Membre::new).orElse(null);
    }
}
