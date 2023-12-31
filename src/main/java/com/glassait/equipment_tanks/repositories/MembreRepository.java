package com.glassait.equipment_tanks.repositories;

import com.glassait.equipment_tanks.model.membre.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembreRepository extends JpaRepository<MemberModel, Integer> {
}
