package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.abstracts.GlassaitLogger;
import com.glassait.equipment_tanks.abstracts.membre.Member;
import com.glassait.equipment_tanks.abstracts.membre.Members;
import com.glassait.equipment_tanks.model.membre.MemberModel;
import com.glassait.equipment_tanks.repositories.MembreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembreService extends GlassaitLogger {
    /**
     * Beginning of the log sentence
     */
    private static final String START_LOG = "The account n°: ";

    /**
     * The instance of the member repository
     */
    private final MembreRepository membreRepository;
    /**
     * The instance of the wot service
     */
    private final WotService wotService;

    /**
     * Find the user by is account id
     *
     * @param accountId The account id of the user
     * @return An optional with the result of the search
     */
    public Optional<MemberModel> findById(int accountId) {
        return this.membreRepository.findById(accountId);
    }

    /**
     * Update the member database with the data get from Wargaming
     *
     * @return true
     */
    public String updateMembers() {
        Members fromWot = this.wotService.getClanMembers();
        Members fromDB = new Members(this.getAll());

        fromWot.getMembers().forEach(member -> {
            List<Member> list = fromDB.getMembers().stream().filter(member1 -> member.getAccount_id() == member1.getAccount_id()).toList();
            if (list.size() == 1) {
                Member memberFromDB = list.get(0);
                if (!memberFromDB.getRole().equals(member.getRole())) {
                    super.logDebug(member.getAccount_id() + " need to update the role from " + memberFromDB.getRole() + " to " + member.getRole());
                    this.updateMember(new MemberModel(memberFromDB.getAccount_id(), member.getRole()));
                }
            } else {
                super.logDebug(member.getAccount_id() + " is outside the database");
                this.addMember(new MemberModel(member.getAccount_id(), member.getRole()));
            }
        });

        fromDB.getMembers().forEach(member -> {
            List<Member> list = fromWot.getMembers().stream().filter(member1 -> member.getAccount_id() == member1.getAccount_id()).toList();
            if (list.isEmpty()) {
                super.logDebug(member.getAccount_id() + " has leaved the clan");
                this.deleteMember(new MemberModel(member.getAccount_id(), member.getRole()));
            }
        });

        return "Database updated";
    }

    /**
     * Get all the members in the database
     *
     * @return The list of all the members in the database
     */
    private List<MemberModel> getAll() {
        return this.membreRepository.findAll();
    }

    /**
     * Update the member in the database
     *
     * @param memberModel The new data of the user to update
     */
    private void updateMember(MemberModel memberModel) {
        this.membreRepository.saveAndFlush(memberModel);
        super.logDebug(START_LOG + memberModel.getAccountId() + " as been updated");
    }

    /**
     * Delete the user of the database
     *
     * @param memberModel The user to delete
     */
    private void deleteMember(MemberModel memberModel) {
        this.membreRepository.delete(memberModel);
        this.membreRepository.flush();
        super.logDebug(START_LOG + memberModel.getAccountId() + " as been deleted");
    }

    /**
     * Add the user to the database
     *
     * @param memberModel The user to add
     */
    private void addMember(MemberModel memberModel) {
        this.membreRepository.saveAndFlush(memberModel);
        super.logDebug(START_LOG + memberModel.getAccountId() + " as been added");
    }
}
