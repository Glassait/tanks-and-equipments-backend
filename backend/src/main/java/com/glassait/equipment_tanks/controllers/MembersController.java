package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.api.MembersApi;
import com.glassait.equipment_tanks.api.model.MemberDto;
import com.glassait.equipment_tanks.api.model.UpdateDto;
import com.glassait.equipment_tanks.services.MembersService;
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
public class MembersController implements MembersApi {
    /**
     * Instance of the member service
     */
    private final MembersService membersService;
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
        return new ResponseEntity<>(membersService.findById(accountId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UpdateDto> updateMembers(String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.membersService.updateMembers(), HttpStatus.OK);
        }

        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
