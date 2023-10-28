package com.glassait.lchp.tasks;

import com.glassait.lchp.services.MembreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateMemberDB {
    private final MembreService membreService;

    @Scheduled(fixedRate = 1000 * 60 * 60 * 4)
    private void updateMemberInDatabase() {
        log.info("Actualisation automatique de la base de données lancé");
        this.membreService.updateMembers();
    }
}
