package com.glassait.equipment_tanks.abstracts.membre;

import com.glassait.equipment_tanks.model.membre.MemberModel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Members {
    private final List<Member> memberList;

    public Members(List<MemberModel> memberModels) {
        this.memberList = new ArrayList<>();
        memberModels.forEach(memberModel -> this.memberList.add(new Member(memberModel)));
    }
}
