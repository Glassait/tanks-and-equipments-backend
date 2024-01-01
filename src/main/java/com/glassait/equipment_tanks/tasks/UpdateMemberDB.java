package com.glassait.equipment_tanks.tasks;

import com.glassait.equipment_tanks.services.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for updating the member information in the database.
 * It uses the MemberService to fetch the latest member information from the API and update the database.
 * The update frequency is set to every 4 hours using the @Scheduled annotation.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateMemberDB {
    /**
     * The MemberService instance is used to fetch the latest member information from the API.
     */
    private final MemberService memberService;

    /**
     * This method is called by the scheduler to update the member information in the database.
     */
    @Scheduled(fixedRate = 1000 * 60 * 60 * 4)
    public void updateMemberInDatabase() {
        log.info("Actualisation automatique de la base de données lancé");
        this.memberService.updateMembers();
        log.info("Actualisation automatique de la base de données fini");
    }
}
