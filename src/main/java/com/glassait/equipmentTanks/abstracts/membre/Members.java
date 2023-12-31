package com.glassait.equipmentTanks.abstracts.membre;

import com.glassait.equipmentTanks.model.membre.MemberModel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Members {
    private final List<Member> members;

    public Members(List<MemberModel> memberModels) {
        this.members = new ArrayList<>();
        memberModels.forEach(memberModel -> this.members.add(new Member(memberModel)));
    }
}
