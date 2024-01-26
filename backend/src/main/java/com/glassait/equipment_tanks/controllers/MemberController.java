package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.api.MembersApi;
import com.glassait.equipment_tanks.api.model.MemberDto;
import com.glassait.equipment_tanks.api.model.UpdateDto;
import com.glassait.equipment_tanks.services.MemberService;
import com.glassait.equipment_tanks.services.WotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController implements MembersApi {
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
    @Override
    public ResponseEntity<MemberDto> members(Integer accountId) {
        return new ResponseEntity<>(memberService.findById(accountId), HttpStatus.OK);
    }

    /**
     * Api to update the database
     *
     * @param accessToken The wot access token of the user
     * @return A string if the access token in valide, else a 401 error
     */
    @Override
    public ResponseEntity<UpdateDto> updateMembers(String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.memberService.updateMembers(), HttpStatus.OK);
        }

        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
