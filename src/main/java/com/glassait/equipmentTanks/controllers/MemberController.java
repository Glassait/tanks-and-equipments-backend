package com.glassait.equipmentTanks.controllers;

import com.glassait.equipmentTanks.abstracts.GlassaitLogger;
import com.glassait.equipmentTanks.abstracts.membre.Member;
import com.glassait.equipmentTanks.services.MembreService;
import com.glassait.equipmentTanks.services.WotService;
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
    /**
     * Instance of the member service
     */
    private final MembreService membreService;
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
    @RequestMapping(value = "api/member")
    public ResponseEntity<Member> isClanMember(@RequestParam("account_id") Integer accountId) {
        Member member = membreService.findById(accountId).map(Member::new).orElse(null);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    /**
     * Api to update the database
     *
     * @param accessToken The wot access token of the user
     * @return A string if the access token in valide, else a 401 error
     */
    @RequestMapping(value = "api/member/update")
    public ResponseEntity<String> updateClanMember(@RequestParam(name = "access_token") String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            super.logDebug("The access token {" + accessToken + "} is valide");
            return new ResponseEntity<>(this.membreService.updateMembers(), HttpStatus.OK);
        }
        super.logError("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
