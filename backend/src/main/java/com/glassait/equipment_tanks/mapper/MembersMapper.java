package com.glassait.equipment_tanks.mapper;

import com.glassait.equipment_tanks.api.model.MemberDto;
import com.glassait.equipment_tanks.model.member.MemberModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MembersMapper {
    @Mapping(source = "role", target = "role")
    @Mapping(source = "accountId", target = "accountId")
    MemberDto convertMemberModelToMemberDto(MemberModel model);

    List<MemberDto> convertListMemberModelToListMemberDto(List<MemberModel> model);
}
