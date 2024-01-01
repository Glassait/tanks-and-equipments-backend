package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.abstracts.member.Member;
import com.glassait.equipment_tanks.services.MemberService;
import com.glassait.equipment_tanks.services.WotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    /**
     * Instance of the member service
     */
    private final MemberService memberService;
    /**
     * Instance of the wot service
     */
    private final WotService wotService;

    /**
     * Api to check if the user is a clan member
     *
     * @param accountId The account id of the user
     * @return The member if found, else null
     */
    @GetMapping(value = "api/member")
    public ResponseEntity<Member> isClanMember(@RequestParam("account_id") Integer accountId) {
        Member member = memberService.findById(accountId)
                                     .map(Member::new)
                                     .orElse(null);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    /**
     * Api to update the database
     *
     * @param accessToken The wot access token of the user
     * @return A string if the access token in valide, else a 401 error
     */
    @PostMapping(value = "api/member/update")
    public ResponseEntity<String> updateClanMember(@RequestParam(name = "access_token") String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.memberService.updateMembers(), HttpStatus.OK);
        }

        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
