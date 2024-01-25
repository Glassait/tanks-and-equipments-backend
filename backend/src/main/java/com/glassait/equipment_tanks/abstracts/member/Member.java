package com.glassait.equipment_tanks.abstracts.member;

import com.glassait.equipment_tanks.model.member.MemberModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Member {
    private final String role;
    private final int account_id; // NOSONAR

    public Member(MemberModel memberModel) {
        this.role = memberModel.getRole();
        this.account_id = memberModel.getAccountId();
    }
}
