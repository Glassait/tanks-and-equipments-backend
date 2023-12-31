package com.glassait.equipment_tanks.tasks;

import com.glassait.equipment_tanks.services.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateMemberDB {
    /**
     * Instance of the member service
     */
    private final MemberService memberService;

    @Scheduled(fixedRate = 1000 * 60 * 60 * 4)
    private void updateMemberInDatabase() {
        log.info("Actualisation automatique de la base de données lancé");
        this.memberService.updateMembers();
    }
}
