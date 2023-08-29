package com.glassait.lchp.abstracts.membre;

import com.glassait.lchp.model.membre.MemberModel;
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
