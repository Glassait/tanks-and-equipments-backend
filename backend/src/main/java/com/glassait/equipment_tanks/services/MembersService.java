package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.api.model.MemberDto;
import com.glassait.equipment_tanks.api.model.MembersDto;
import com.glassait.equipment_tanks.api.model.UpdateDto;
import com.glassait.equipment_tanks.mapper.MembersMapper;
import com.glassait.equipment_tanks.model.member.MemberModel;
import com.glassait.equipment_tanks.repositories.MembersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class MembersService {
    /**
     * Beginning of the log sentence
     */
    private static final String START_LOG = "The account n°: ";
    /**
     * Instance of the member mapper
     */
    private static final MembersMapper MEMBERS_MAPPER = Mappers.getMapper(MembersMapper.class);

    /**
     * Instance of the member repository
     */
    private final MembersRepository membersRepository;
    /**
     * Instance of the wot service
     */
    private final WotService wotService;

    /**
     * Find the user by is account id
     *
     * @param accountId The account id of the user
     * @return An optional with the result of the search
     */
    public MemberDto findById(int accountId) {
        return MEMBERS_MAPPER.convertMemberModelToMemberDto(this.membersRepository.findById(accountId).orElse(null));
    }

    /**
     * Update the member database with the data get from Wargaming
     *
     * @return true
     */
    public UpdateDto updateMembers() {
        var fromWot = this.wotService.getClanMembers();
        var fromDB = new MembersDto();
        fromDB.setMembers(this.getAll());

        fromWot.getMembers().forEach(member -> {
            List<MemberDto> list = fromDB.getMembers().stream().filter(member1 -> Objects.equals(member.getAccountId(),
                    member1.getAccountId())).toList();
            if (list.size() == 1) {
                MemberDto memberFromDB = list.get(0);
                if (!memberFromDB.getRole().equals(member.getRole())) {
                    log.debug(
                            member.getAccountId() + " need to update the role from " + memberFromDB.getRole() + " to " + member.getRole());
                    this.updateMember(new MemberModel(memberFromDB.getAccountId(), member.getRole()));
                }
            } else {
                log.debug(member.getAccountId() + " is outside the database");
                this.addMember(new MemberModel(member.getAccountId(), member.getRole()));
            }
        });

        fromDB.getMembers().forEach(member -> {
            List<MemberDto> list = fromWot.getMembers().stream().filter(member1 -> Objects.equals(member.getAccountId(),
                    member1.getAccountId())).toList();
            if (list.isEmpty()) {
                log.debug(member.getAccountId() + " has leaved the clan");
                this.deleteMember(new MemberModel(member.getAccountId(), member.getRole()));
            }
        });

        var response = new UpdateDto();
        response.setStatus("OK");

        return response;
    }

    /**
     * Get all the members in the database
     *
     * @return The list of all the members in the database
     */
    private List<MemberDto> getAll() {
        return MEMBERS_MAPPER.convertListMemberModelToListMemberDto(this.membersRepository.findAll());
    }

    /**
     * Update the member in the database
     *
     * @param memberModel The new data of the user to update
     */
    private void updateMember(MemberModel memberModel) {
        this.membersRepository.saveAndFlush(memberModel);
        log.debug(START_LOG + memberModel.getAccountId() + " as been updated");
    }

    /**
     * Delete the user of the database
     *
     * @param memberModel The user to delete
     */
    private void deleteMember(MemberModel memberModel) {
        this.membersRepository.delete(memberModel);
        this.membersRepository.flush();
        log.debug(START_LOG + memberModel.getAccountId() + " as been deleted");
    }

    /**
     * Add the user to the database
     *
     * @param memberModel The user to add
     */
    private void addMember(MemberModel memberModel) {
        this.membersRepository.saveAndFlush(memberModel);
        log.debug(START_LOG + memberModel.getAccountId() + " as been added");
    }
}
