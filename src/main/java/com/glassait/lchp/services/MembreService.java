package com.glassait.lchp.services;

import com.glassait.lchp.abstracts.membre.Member;
import com.glassait.lchp.abstracts.membre.Members;
import com.glassait.lchp.model.membre.MemberModel;
import com.glassait.lchp.repositories.MembreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MembreService {
    private static final String START_LOG = "The account n°: ";

    private final MembreRepository membreRepository;
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

        fromWot.getMemberList().forEach(member -> {
            List<Member> list = fromDB.getMemberList().stream().filter(member1 -> member.getAccountId() == member1.getAccountId()).toList();
            if (list.size() == 1) {
                Member memberFromDB = list.get(0);
                if (!memberFromDB.getRole().equals(member.getRole())) {
                    log.debug(member.getAccountId() + " need to update the role from " + memberFromDB.getRole() + " to " + member.getRole());
                    this.updateMember(new MemberModel(memberFromDB.getAccountId(), member.getRole()));
                }
            } else {
                log.debug(member.getAccountId() + " is outside the database");
                this.addMember(new MemberModel(member.getAccountId(), member.getRole()));
            }
        });

        fromDB.getMemberList().forEach(member -> {
            List<Member> list = fromWot.getMemberList().stream().filter(member1 -> member.getAccountId() == member1.getAccountId()).toList();
            if (list.isEmpty()) {
                log.debug(member.getAccountId() + " has leaved the clan");
                this.deleteMember(new MemberModel(member.getAccountId(), member.getRole()));
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
        log.debug(START_LOG + memberModel.getAccountId() + " as been updated");
    }

    /**
     * Delete the user of the database
     *
     * @param memberModel The user to delete
     */
    private void deleteMember(MemberModel memberModel) {
        this.membreRepository.delete(memberModel);
        this.membreRepository.flush();
        log.debug(START_LOG + memberModel.getAccountId() + " as been deleted");
    }

    /**
     * Add the user to the database
     *
     * @param memberModel The user to add
     */
    private void addMember(MemberModel memberModel) {
        this.membreRepository.saveAndFlush(memberModel);
        log.debug(START_LOG + memberModel.getAccountId() + " as been added");
    }

    public void test() {
        System.out.println("THIS IS MAYBE A TEST");
        log.debug("THIS IS A TEST");
    }
}
