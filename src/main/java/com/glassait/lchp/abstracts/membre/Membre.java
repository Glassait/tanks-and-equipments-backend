package com.glassait.lchp.abstracts.membre;

import com.glassait.lchp.model.membre.MembreModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Membre {
    private String role;
    private int account_id;

    public Membre(MembreModel membreModel) {
        this.role = membreModel.getRole();
        this.account_id = membreModel.getAccountId();
    }
}
