package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.GlassaitLogger;
import com.glassait.lchp.abstracts.membre.Member;
import com.glassait.lchp.services.MembreService;
import com.glassait.lchp.services.WotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class MemberController extends GlassaitLogger {
    private final MembreService membreService;
    private final WotService wotService;

    @RequestMapping(value = "api/member")
    public ResponseEntity<Member> isClanMember(@RequestParam("account_id") Integer accountId) {
        Member member = membreService.findById(accountId).map(Member::new).orElse(null);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @RequestMapping(value = "api/member/update")
    public ResponseEntity<String> updateClanMember(@RequestParam(name = "access_token") String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.membreService.updateMembers(), HttpStatus.OK);
        }
        super.logError("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
