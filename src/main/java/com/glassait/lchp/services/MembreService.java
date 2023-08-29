package com.glassait.lchp.services;

import com.glassait.lchp.abstracts.membre.Member;
import com.glassait.lchp.abstracts.membre.Members;
import com.glassait.lchp.model.membre.MemberModel;
import com.glassait.lchp.repositories.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembreService {
    @Autowired
    private MembreRepository membreRepository;

    @Autowired
    private WotService wotService;

    public Optional<MemberModel> isClanMember(int accountId) {
        return membreRepository.findById(accountId);
    }

    public boolean updateMembers() {
        Members fromWot = this.wotService.getClanMembers();
        Members fromDB = new Members(this.getAll());

        fromWot.getMembers().forEach(member -> {
            List<Member> list = fromDB.getMembers().stream().filter(member1 -> member.getAccount_id() == member1.getAccount_id()).toList();
            if (list.size() == 1) {
                Member memberFromDB = list.get(0);
                if (!memberFromDB.getRole().equals(member.getRole())) {
                    System.out.println(member.getAccount_id() + " need to update the role from " + memberFromDB.getRole() + " to " + member.getRole());
                    this.updateMember(new MemberModel(memberFromDB.getAccount_id(), member.getRole()));
                }
            } else {
                System.out.println(member.getAccount_id() + " is outside the database");
                this.addMember(new MemberModel(member.getAccount_id(), member.getRole()));
            }
        });

        fromDB.getMembers().forEach(member -> {
            List<Member> list = fromWot.getMembers().stream().filter(member1 -> member.getAccount_id() == member1.getAccount_id()).toList();
            if (list.isEmpty()) {
                System.out.println(member.getAccount_id() + " has leaved the clan");
                this.deleteMember(new MemberModel(member.getAccount_id(), member.getRole()));
            }
        });

        return true;
    }

    public List<MemberModel> getAll() {
        return membreRepository.findAll();
    }

    public void updateMember(MemberModel memberModel) {
        this.membreRepository.saveAndFlush(memberModel);
        System.out.println("The account n°: " + memberModel.getAccountId() + " as been updated");
    }

    public void deleteMember(MemberModel memberModel) {
        this.membreRepository.delete(memberModel);
        this.membreRepository.flush();
        System.out.println("The account n°: " + memberModel.getAccountId() + " as been deleted");
    }

    public void addMember(MemberModel memberModel) {
        this.membreRepository.saveAndFlush(memberModel);
        System.out.println("The account n°: " + memberModel.getAccountId() + " as been added");
    }
}
