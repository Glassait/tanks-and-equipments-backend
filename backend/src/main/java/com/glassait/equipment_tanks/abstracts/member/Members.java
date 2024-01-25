package com.glassait.equipment_tanks.abstracts.member;

import com.glassait.equipment_tanks.model.member.MemberModel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Members {
    private final List<Member> members; // NOSONAR

    public Members(List<MemberModel> memberModels) {
        this.members = new ArrayList<>();
        memberModels.forEach(memberModel -> this.members.add(new Member(memberModel)));
    }
}
