package com.glassait.lchp.abstracts.membre;

import com.glassait.lchp.model.membre.MemberModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Member {
    private final String role;
    private final int accountId;

    public Member(MemberModel memberModel) {
        this.role = memberModel.getRole();
        this.accountId = memberModel.getAccountId();
    }
}
