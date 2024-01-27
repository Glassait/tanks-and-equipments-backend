package com.glassait.equipment_tanks.repositories;

import com.glassait.equipment_tanks.model.member.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<MemberModel, Integer> {
}
